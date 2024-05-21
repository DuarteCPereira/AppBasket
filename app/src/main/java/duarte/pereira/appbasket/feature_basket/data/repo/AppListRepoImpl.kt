package duarte.pereira.appbasket.feature_basket.data.repo

import android.util.Log
import duarte.pereira.appbasket.feature_basket.data.di.IoDispatcher
import duarte.pereira.appbasket.feature_basket.data.local.BasketDao
import duarte.pereira.appbasket.feature_basket.data.mapper.toAppItemListFromLocal
import duarte.pereira.appbasket.feature_basket.data.mapper.toLocalItemListFromRemote
import duarte.pereira.appbasket.feature_basket.data.remote.BasketApi
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.feature_basket.domain.repo.AppListRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

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
        if (response.isSuccessful && response.body() != null) {
            dao.addAllApps(response.body()!!.responses.listApps.datasets.all.data.list.toLocalItemListFromRemote())
        }
//        dao.addAllApps(remoteAppItems.toLocalItemListFromRemote())
    }

    private fun isCacheEmpty(): Boolean = dao.getAllApps().isEmpty()
}
