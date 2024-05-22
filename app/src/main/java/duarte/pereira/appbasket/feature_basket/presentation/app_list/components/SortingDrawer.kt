package duarte.pereira.appbasket.feature_basket.presentation.app_list.components

import androidx.compose.material3.Divider
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import duarte.pereira.appbasket.core.presentation.components.IconRow
import duarte.pereira.appbasket.feature_basket.domain.util.Order
import duarte.pereira.appbasket.feature_basket.domain.util.Sort

@Composable
fun SortingDrawer(
    appItemOrder: Order,
    onOrderChange: (Order) -> Unit
) {
    NavigationDrawerItem(
        label = {
            IconRow(
                text = "Name",
                isChecked = appItemOrder::class == Order.Name::class
            )
        },
        selected = false,
        onClick = { onOrderChange(Order.Name(appItemOrder.sort)) }
    )

    NavigationDrawerItem(
        label = {
            IconRow(
                text = "Downloads",
                isChecked = appItemOrder::class == Order.Downloads::class
            )
        },
        selected = false,
        onClick = { onOrderChange(Order.Downloads(appItemOrder.sort)) }
    )

    NavigationDrawerItem(
        label = {
            IconRow(
                text = "Rating",
                isChecked = appItemOrder::class == Order.Rating::class
            )
        },
        selected = false,
        onClick = { onOrderChange(Order.Rating(appItemOrder.sort)) }
    )

    Divider()

    NavigationDrawerItem(
        label = {
            IconRow(
                text = "Sort Down",
                isChecked = appItemOrder.sort == Sort.Down
            )
        },
        selected = false,
        onClick = {
            onOrderChange(appItemOrder.copy(Sort.Down))
        }
    )

    NavigationDrawerItem(
        label = {
            IconRow(
                text = "Sort Up",
                isChecked = appItemOrder.sort == Sort.Up
            )
        },
        selected = false,
        onClick = {
            onOrderChange(appItemOrder.copy(Sort.Up))
        }
    )
}
