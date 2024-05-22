package duarte.pereira.appbasket.feature_basket.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "basket")
data class LocalAppItem(
    @PrimaryKey
    val id: Long?,
    val name: String,
    val packageName: String,
    val store_id: Long,
    val store_name: String,
    val vername: String,
    val vercode: Int,
    val md5sum: String,
//    val apk_tags: List<String>,
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

