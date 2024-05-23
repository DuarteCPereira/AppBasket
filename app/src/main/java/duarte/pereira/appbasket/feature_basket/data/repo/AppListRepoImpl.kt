package duarte.pereira.appbasket.feature_basket.data.repo

import android.util.Log
import android.util.Log.i
import duarte.pereira.appbasket.feature_basket.data.di.IoDispatcher
import duarte.pereira.appbasket.feature_basket.data.local.BasketDao
import duarte.pereira.appbasket.feature_basket.data.mapper.toAppItemListFromLocal
import duarte.pereira.appbasket.feature_basket.data.mapper.toLocalItemListFromRemote
import duarte.pereira.appbasket.feature_basket.data.remote.BasketApi
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.feature_basket.domain.repo.AppListRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import kotlin.concurrent.thread

class AppListRepoImpl(
    private val dao: BasketDao,
    private val api: BasketApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : AppListRepo {
    override suspend fun getAllApps(): List<AppItem> {
        getAllAppsFromRemote()
        return dao.getAllApps().toAppItemListFromLocal()
    }

    override suspend fun getAllAppsFromLocalCache(): List<AppItem> =
        dao.getAllApps().toAppItemListFromLocal()

    override suspend fun getAllAppsFromRemote() {
        return withContext(dispatcher) {
            try {
                refreshRoomCache()
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException, is ConnectException, is HttpException -> {
                        Log.e("HTTP", "Error: no response")
                        if (isCacheEmpty()) {
                            Log.e("Cache", "Error: No cached data")
                            throw Exception("Error: Device offline and no data from local cache")
                        }
                    }
                }
            }
        }
    }

    private suspend fun refreshRoomCache() {
        val response = api.getAllApps()
        i("AppBasket", "response: ${response.responses.listApps.datasets.all.data.list}")
        try {
            dao.addAllApps(
                response.responses.listApps.datasets.all.data.list.filterNotNull()
                    .toLocalItemListFromRemote()
            )
        } catch (e: Exception) { i("AppBasket", "$e") }
    }

    private fun isCacheEmpty(): Boolean {
        var empty = true
        if (dao.getAllApps().isNotEmpty()) empty = false
        return empty
    }
}
