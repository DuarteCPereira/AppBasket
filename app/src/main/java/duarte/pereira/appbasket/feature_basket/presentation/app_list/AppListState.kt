package duarte.pereira.appbasket.feature_basket.presentation.app_list

import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.feature_basket.domain.util.Order

data class AppListState(
    val appItems: List<AppItem> = emptyList(),
    val order: Order,
    val isLoading: Boolean = true,
    val error: String? = null
)