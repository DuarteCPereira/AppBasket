package duarte.pereira.appbasket.feature_basket.data.local.dto

import androidx.room.Entity

@Entity(tableName = "apps")
data class LocalApp(
    val name: String,
    val packageName: String,
    val icon: Int,
    val graphic: Int
)
