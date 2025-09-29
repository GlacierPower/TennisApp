package com.glacirepower.tennisapp.match_details.di

import com.glacirepower.tennisapp.match_details.repository.EventRepository
import com.glacirepower.tennisapp.match_details.repository.EventRepositoryImpl
import com.glacirepower.tennisapp.match_details.service.EventService
import com.glacirepower.tennisapp.match_details.service.EventServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class EventModule {

    @Binds
    @Singleton
    abstract fun bindEventRepository(eventRepositoryImpl: EventRepositoryImpl): EventRepository

    @Binds
    @Singleton
    abstract fun bindEventService(eventServiceImpl: EventServiceImpl): EventService
}
