package duarte.pereira.appbasket.feature_basket.domain.model

data class AppItem(
    val name: String,
    val packageName: String,
    val icon: Int,
    val graphic: Int,
    val id: Int?
)
