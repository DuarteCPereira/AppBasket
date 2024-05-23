package duarte.pereira.appbasket.feature_basket.domain.repo

import duarte.pereira.appbasket.feature_basket.domain.model.AppItem

/**
 * Repository interface defining methods for managing app items. This interface abstracts
 * the data retrieval operations from both local cache and remote server, providing a
 * unified access point for accessing app data. Implementations of this interface, such as
 * AppListRepoImpl, will typically be closely integrated with Retrofit API and Room database,
 * but this interface itself remains decoupled from specific implementation details.
 */
interface AppListRepo {
    suspend fun getAllApps(): List<AppItem>
    suspend fun getAllAppsFromLocalCache(): List<AppItem>
    suspend fun getAllAppsFromRemote()
}