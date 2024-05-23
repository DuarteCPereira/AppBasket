package duarte.pereira.appbasket.feature_basket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalAppItem

@Dao
interface BasketDao {
    @Query("SELECT * FROM basket")
    fun getAllApps(): List<LocalAppItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllApps(apps: List<LocalAppItem>)
}