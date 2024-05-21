package duarte.pereira.appbasket.feature_basket.domain.model

data class AppItem(
    val name: String,
    val packageName: String,
    val icon: String,
    val graphic: String,
    val id: Int?,
    val downloads: Long,
    val rating: Double,
    val size: Long
)
