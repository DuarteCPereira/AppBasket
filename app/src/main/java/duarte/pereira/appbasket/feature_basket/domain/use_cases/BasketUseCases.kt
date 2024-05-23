package duarte.pereira.appbasket.feature_basket.domain.use_cases

import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.feature_basket.domain.repo.AppListRepo
import duarte.pereira.appbasket.feature_basket.domain.util.Order
import duarte.pereira.appbasket.feature_basket.domain.util.Sort
import javax.inject.Inject

/**
 * Class responsible for the business logic of the app list feature. It encapsulates both the repo
 * access and the sorting that should be done.
 */
class BasketUseCases @Inject constructor(
    private val repo: AppListRepo
) {
    suspend fun getAllAppItems(
        order: Order,
    ): BasketUseCaseResult {
        var apps = repo.getAllAppsFromLocalCache()

        if (apps.isEmpty()) {
            apps = repo.getAllApps()
        }

        return when (order.sort) {
            is Sort.Down -> {
                when (order) {
                    is Order.Name -> BasketUseCaseResult.Success(apps.sortedByDescending { it.name.lowercase() })
                    is Order.Rating -> BasketUseCaseResult.Success(apps.sortedByDescending { it.rating })
                    is Order.Downloads -> BasketUseCaseResult.Success(apps.sortedByDescending { it.downloads })
                }
            }

            is Sort.Up -> {
                when (order) {
                    is Order.Name -> BasketUseCaseResult.Success(apps.sortedBy { it.name.lowercase() })
                    is Order.Rating -> BasketUseCaseResult.Success(apps.sortedBy { it.rating })
                    is Order.Downloads -> BasketUseCaseResult.Success(apps.sortedBy { it.downloads })
                }
            }
        }
    }

}

sealed class BasketUseCaseResult {
    data class Success(val appItems: List<AppItem>) : BasketUseCaseResult()
    data class Error(val message: String) : BasketUseCaseResult()
}