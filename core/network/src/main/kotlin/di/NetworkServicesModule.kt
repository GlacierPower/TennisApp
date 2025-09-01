package di

import api.api.CompetitorsApi
import api.api.RankingApi
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
    fun provideTennisApi(@Tennis retrofit: Retrofit): RankingApi =
        retrofit.create(RankingApi::class.java)

    @Provides
    @Singleton
    fun provideCompetitorsApi(@Tennis retrofit: Retrofit): CompetitorsApi =
        retrofit.create(CompetitorsApi::class.java)
}