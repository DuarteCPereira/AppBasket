package duarte.pereira.appbasket.feature_basket.domain.util

sealed class Sort {
    object Up: Sort()
    object Down: Sort()
}