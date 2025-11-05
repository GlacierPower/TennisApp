package com.glacierpower.tennisapp.data.tournament_details.di

import com.glacierpower.tennisapp.data.tournament_details.repository.TournamentDetailsRepositoryImpl
import com.glacierpower.tennisapp.data.tournament_details.service.TournamentDetailsService
import com.glacierpower.tennisapp.data.tournament_details.service.TournamentDetailsServiceImpl
import com.glacierpower.tennisapp.domain.tournament_details.repository.TournamentDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TournamentDetailsModule {

    @Binds
    @Singleton
    fun bindTournamentDetailsRepository(impl: TournamentDetailsRepositoryImpl): TournamentDetailsRepository

    @Binds
    @Singleton
    fun bindTournamentDetailsService(impl: TournamentDetailsServiceImpl): TournamentDetailsService
}
