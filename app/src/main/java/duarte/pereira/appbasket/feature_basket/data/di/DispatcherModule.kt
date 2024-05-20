package duarte.pereira.appbasket.feature_basket.data.di

import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

// TODO: Study this
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

object DispatcherModule {
    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}