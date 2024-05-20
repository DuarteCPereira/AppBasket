package duarte.pereira.appbasket.feature_basket.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket")
data class LocalApp(
    val name: String,
    val packageName: String,
    val icon: Int,
    val graphic: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)
