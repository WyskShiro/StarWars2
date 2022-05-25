package will.shiro.starwars2.di.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import will.shiro.starwars2.util.scheduler.SchedulerProvider
import will.shiro.starwars2.util.scheduler.SchedulerProviderImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class SchedulerModule {

    @Binds
    abstract fun bindsSchedulerProvider(
        schedulerProviderImpl: SchedulerProviderImpl
    ): SchedulerProvider
}
