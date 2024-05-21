package duarte.pereira.appbasket.feature_basket.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RemoteAppItem(
    val id: Int?,
    val name: String,
    @SerializedName("package")
    val packageName: String,
    val store_id: Int,
    val store_name: String,
    val vername: String,
    val vercode: Int,
    val md5sum: String,
    val apk_tags: List<String>,
    val size: Long,
    val downloads: Long,
    val pdownloads: Long,
    val added: String,
    val modified: String,
    val updated: String,
    val rating: Double,
    val icon: String,
    val graphic: String,
    val uptype: String
)

data class Data(
    val list: List<RemoteAppItem>
)

data class All(
    val data: Data
)

data class Datasets(
    val all: All
)

data class ListApps(
    val datasets: Datasets
)

data class Responses(
    val listApps: ListApps
)

data class AppListResponse(
    val responses: Responses
)