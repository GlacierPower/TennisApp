package com.glacierpower.tennisapp.di

import android.content.Context
import com.glacierpower.tennisapp.data.dao.TennisDao
import com.glacierpower.tennisapp.data.dao.TennisDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideNewsDataBase(context: Context): TennisDataBase {
        return TennisDataBase.getTennisDataBaseInstance(context)
    }

    @Provides
    fun provideTennisDao(tennisDataBase: TennisDataBase): TennisDao {
        return tennisDataBase.getTennisDao()
    }
}