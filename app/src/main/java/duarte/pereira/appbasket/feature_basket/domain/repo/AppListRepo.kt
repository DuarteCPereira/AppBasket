package duarte.pereira.appbasket.feature_basket.domain.repo

import duarte.pereira.appbasket.feature_basket.domain.model.AppItem

// TODO improve Doc: Updates the local cache
// When we are finish with the app this will be heavily tied to retrofit api and room database
// This class acts as a dummy implementation of this repo class, without being tied to room or retrofit
interface AppListRepo {
    suspend fun getAllApps(): List<AppItem>
    suspend fun getAllAppsFromLocalCache(): List<AppItem>
    suspend fun getAllAppsFromRemote()
}