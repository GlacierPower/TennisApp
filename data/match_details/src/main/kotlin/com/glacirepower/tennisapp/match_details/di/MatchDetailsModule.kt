package com.glacirepower.tennisapp.match_details.di

import com.glacirepower.tennisapp.match_details.repository.MatchDetailsRepositoryImpl
import com.glacirepower.tennisapp.match_details.repository.MatchDetailsRepository
import com.glacirepower.tennisapp.match_details.service.MatchDetailsService
import com.glacirepower.tennisapp.match_details.service.MatchDetailsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MatchDetailsModule {

    @Binds
    @Singleton
    abstract fun bindMatchDetailsRepository(impl: MatchDetailsRepositoryImpl): MatchDetailsRepository

    @Binds
    @Singleton
    abstract fun bindMatchDetailsService(impl: MatchDetailsServiceImpl): MatchDetailsService
}
