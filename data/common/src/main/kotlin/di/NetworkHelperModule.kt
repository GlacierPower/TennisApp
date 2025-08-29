package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import networkHelper.NetworkHelper
import networkHelper.NetworkHelperImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkHelperModule {
    @Binds
    @Singleton
    fun bindNetworkHelperRepository(impl: NetworkHelperImpl): NetworkHelper
}