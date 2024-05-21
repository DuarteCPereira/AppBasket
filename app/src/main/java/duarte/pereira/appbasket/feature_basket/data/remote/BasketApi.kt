package duarte.pereira.appbasket.feature_basket.data.remote

import duarte.pereira.appbasket.feature_basket.data.remote.dto.AppListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface BasketApi {
//    @GET("bulkRequest/api_list/listApps")
//    suspend fun getAllApps(): List<RemoteAppItem>

    @GET("bulkRequest/api_list/listApps")
    suspend fun getAllApps(): Response<AppListResponse>

    // TODO re-think if needed
//    @GET("listApps?orderBy=\"id\"")
//    suspend fun getAppById(@Query("equalTo") id: Int?): Map<String, RemoteAppItem>
}