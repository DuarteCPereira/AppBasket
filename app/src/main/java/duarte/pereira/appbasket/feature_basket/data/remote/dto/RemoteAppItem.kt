package duarte.pereira.appbasket.feature_basket.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RemoteAppItem(
    val id: Long?,
    val name: String,
    @SerializedName("package")
    val packageName: String,
    val store_id: Long,
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
    val graphic: String?,
    val uptype: String
)

data class ApiResponse(
    val status: String,
    val responses: Responses
)

data class Responses(
    val listApps: ListApps
)

data class ListApps(
    val info: Info,
    val datasets: Datasets
)

data class Info(
    val status: String,
    val time: Time
)

data class Time(
    val seconds: Double,
    val human: String
)

data class Datasets(
    val all: All
)

data class All(
    val info: Info,
    val data: Data
)

data class Data(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val next: Int,
    val hidden: Int,
    val list: List<RemoteAppItem>
)
