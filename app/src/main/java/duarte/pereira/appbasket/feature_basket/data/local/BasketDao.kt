package duarte.pereira.appbasket.feature_basket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalAppItem

/**
 * Defines the Data Access Object (DAO) for interacting with the local database.
 * Provides methods for querying and inserting app items into the database.
 */
@Dao
interface BasketDao {
    @Query("SELECT * FROM basket")
    fun getAllApps(): List<LocalAppItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllApps(apps: List<LocalAppItem>)
}