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

    // TODO re-think if needed
//    @Query("SELECT * FROM basket WHERE id = :id")
//    suspend fun getApp(id: Int): LocalAppItem?

    // TODO re-think if needed
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addApp(app: LocalAppItem): Long

    // TODO re-think if needed
/*
    @Delete
    suspend fun deleteAppItem(app: LocalApp)*/
}