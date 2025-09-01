package com.glacierpower.tennisapp.navigation.di

import com.glacierpower.tennisapp.navigation.navigatorsImpls.RankingNavigatorImpl
import com.glacierpower.tennisapp.presentation.ranking.navigation.RankingNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class ExternalNavigatorModule {

    @Binds
    abstract fun bindRankingNavigator(impl: RankingNavigatorImpl): RankingNavigator
}