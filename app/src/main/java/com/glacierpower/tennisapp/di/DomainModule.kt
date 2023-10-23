package com.glacierpower.tennisapp.di

import com.glacierpower.tennisapp.domain.events.LiveEventInteractor
import com.glacierpower.tennisapp.domain.events.LiveEventsRepository
import com.glacierpower.tennisapp.domain.palyer_details.PlayerDetailsInteractor
import com.glacierpower.tennisapp.domain.palyer_details.PlayerDetailsRepository
import com.glacierpower.tennisapp.domain.ranking.RankingInteractor
import com.glacierpower.tennisapp.domain.ranking.RankingRepository
import com.glacierpower.tennisapp.domain.search.SearchInteractor
import com.glacierpower.tennisapp.domain.search.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providePlayerDetailsInteractor(
        playerDetailsRepository: PlayerDetailsRepository
    ):PlayerDetailsInteractor{
        return PlayerDetailsInteractor(playerDetailsRepository)
    }
    @Provides
    fun provideRankingInteractor(
        rankingRepository: RankingRepository
    ): RankingInteractor {
        return RankingInteractor(rankingRepository)
    }

    @Provides
    fun provideSearchInteracror(
        searchRepository: SearchRepository
    ): SearchInteractor {
        return SearchInteractor(searchRepository)
    }

    @Provides
    fun provideLiveEventInteractor(
        liveEventsRepository: LiveEventsRepository
    ): LiveEventInteractor {
        return LiveEventInteractor(liveEventsRepository)
    }
}