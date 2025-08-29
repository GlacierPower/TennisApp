package di

import api.api.TennisApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import qualifiers.Tennis
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkServicesModule {

    @Provides
    @Singleton
    fun provideTennisApi(@Tennis retrofit: Retrofit): TennisApi =
        retrofit.create(TennisApi::class.java)
}