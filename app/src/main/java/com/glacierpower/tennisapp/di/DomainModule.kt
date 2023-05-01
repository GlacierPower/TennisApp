package com.glacierpower.tennisapp.di

import com.glacierpower.tennisapp.domain.RankingInteractor
import com.glacierpower.tennisapp.domain.RankingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideRankingInteractor(
        rankingRepository: RankingRepository
    ): RankingInteractor {
        return RankingInteractor(rankingRepository)
    }
}