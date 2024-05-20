package duarte.pereira.appbasket.feature_basket.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RemoteAppItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("package")
    val packageName: String,
    @SerializedName("icon")
    val icon: Int,
    @SerializedName("graphic")
    val graphic: Int,
    @SerializedName("id")
    val id: Int?
)