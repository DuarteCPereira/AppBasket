package duarte.pereira.appbasket.feature_basket.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import duarte.pereira.appbasket.feature_basket.data.local.BasketDao
import duarte.pereira.appbasket.feature_basket.data.local.BasketDatabase
import duarte.pereira.appbasket.feature_basket.data.remote.BasketApi
import duarte.pereira.appbasket.feature_basket.data.repo.AppListRepoImpl
import duarte.pereira.appbasket.feature_basket.domain.repo.AppListRepo
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasketModule {

    @Provides
    fun providesRetroFitApi(retrofit: Retrofit): BasketApi {
        return retrofit.create(BasketApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(APPS_BASE_URL)
            .build()
    }

    @Provides
    fun providesRoomDao(database: BasketDatabase): BasketDao {
        return database.dao
    }

    @Singleton
    @Provides
    fun providesRoomDb(
        @ApplicationContext appContext: Context
    ): BasketDatabase =
        Room.databaseBuilder(
            appContext.applicationContext,
            BasketDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesTodoRepo(db: BasketDatabase, api: BasketApi, @IoDispatcher dispatcher: CoroutineDispatcher): AppListRepo {
        return AppListRepoImpl(db.dao, api, dispatcher)
    }

    private const val DATABASE_NAME = "basket_database"
    private const val APPS_BASE_URL = "https://ws2.aptoide.com/api/6/bulkRequest/api_list/listApps/"
}
