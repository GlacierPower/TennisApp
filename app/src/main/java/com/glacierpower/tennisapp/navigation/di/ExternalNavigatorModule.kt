
package com.glacierpower.tennisapp.navigation.di

import com.glacierpower.tennisapp.features.player_profile.navigation.PlayerProfileNavigator
import com.glacierpower.tennisapp.features.ranking.navigation.RankingNavigator
import com.glacierpower.tennisapp.navigation.navigatorsImpls.PlayerProfileNavigatorImpl
import com.glacierpower.tennisapp.navigation.navigatorsImpls.RankingNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class ExternalNavigatorModule {

    @Binds
    abstract fun bindRankingNavigator(impl: RankingNavigatorImpl): RankingNavigator

    @Binds
    abstract fun bindPlayerProfileNavigator(impl: PlayerProfileNavigatorImpl): PlayerProfileNavigator
}
