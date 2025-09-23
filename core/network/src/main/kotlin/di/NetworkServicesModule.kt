package di

import api.api.CompetitorsApi
import api.api.CountryFlagApi
import api.api.EventApi
import api.api.RankingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import qualifiers.CountryFlags
import qualifiers.Tennis
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkServicesModule {

    @Provides
    @Singleton
    fun provideTennisApi(@Tennis retrofit: Retrofit): RankingApi =
        retrofit.create(RankingApi::class.java)

    @Provides
    @Singleton
    fun provideCompetitorsApi(@Tennis retrofit: Retrofit): CompetitorsApi =
        retrofit.create(CompetitorsApi::class.java)

    @Provides
    @Singleton
    fun provideEventApi(@Tennis retrofit: Retrofit): EventApi =
        retrofit.create(EventApi::class.java)

    @Provides
    @Singleton
    fun provideCountryFlagsApi(@CountryFlags retrofit: Retrofit): CountryFlagApi =
        retrofit.create(CountryFlagApi::class.java)
}
