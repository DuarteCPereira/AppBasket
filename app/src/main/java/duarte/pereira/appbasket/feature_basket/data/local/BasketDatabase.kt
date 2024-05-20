package duarte.pereira.appbasket.feature_basket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalApp

@Database(
    entities = [LocalApp::class],
    version = 1,
    exportSchema = false
)
abstract class AppsDatabase: RoomDatabase() {
    abstract val dao: BasketDao

    companion object {
        const val DATABASE_NAME = "basket_db"
    }
}