package duarte.pereira.appbasket.feature_basket.domain.util

sealed class Order(
    val sort: Sort
) {
    class Name(sort: Sort): Order(sort)
    class Size(sort: Sort): Order(sort)
    class Downloads(sort: Sort): Order(sort)

    // TODO re-think naming
    fun copy(sort: Sort): Order =
        when(this) {
            is Name -> Name(sort)
            is Size -> Size(sort)
            is Downloads -> Downloads(sort)
        }
}