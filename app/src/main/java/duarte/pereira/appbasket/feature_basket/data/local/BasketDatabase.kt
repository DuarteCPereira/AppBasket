package duarte.pereira.appbasket.feature_basket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalAppItem

@Database(
    entities = [LocalAppItem::class],
    version = 1,
    exportSchema = false
)
abstract class BasketDatabase: RoomDatabase() {
    abstract val dao: BasketDao

    companion object {
        const val DATABASE_NAME = "basket_db"
    }
}