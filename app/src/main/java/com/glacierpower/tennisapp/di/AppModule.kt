package com.glacierpower.tennisapp.di

import android.content.Context
import com.yourpackage.data.common.repository.LoggerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import repository.LoggerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideLoggerRepository(): LoggerRepository {
        return LoggerRepositoryImpl()
    }
}
