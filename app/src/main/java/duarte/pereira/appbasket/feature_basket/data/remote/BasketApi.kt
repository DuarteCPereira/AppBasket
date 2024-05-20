package duarte.pereira.appbasket.feature_basket.data.remote

import duarte.pereira.appbasket.feature_basket.data.remote.dto.RemoteAppItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BasketApi {
    @GET("listApps")
    suspend fun getAllApps(): List<RemoteAppItem>

    // TODO re-think if needed
//    @GET("listApps?orderBy=\"id\"")
//    suspend fun getAppById(@Query("equalTo") id: Int?): Map<String, RemoteAppItem>
}