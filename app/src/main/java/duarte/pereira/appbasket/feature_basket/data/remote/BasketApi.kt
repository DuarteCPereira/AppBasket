package duarte.pereira.appbasket.feature_basket.data.remote

import duarte.pereira.appbasket.feature_basket.data.remote.dto.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
* Retrofit interface for defining API endpoints related to the basket feature.
* Provides a method for retrieving all apps from the remote server.
*/
interface BasketApi {
    @GET("bulkRequest/api_list/listApps")
    suspend fun getAllApps(): ApiResponse
}