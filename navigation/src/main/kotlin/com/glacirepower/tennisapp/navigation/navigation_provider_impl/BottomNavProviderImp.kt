package com.glacirepower.tennisapp.navigation.navigation_provider_impl

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.glacierpower.tennisapp.features.ranking.ui.RankingScreen
import com.glacirepower.tennisapp.navigation.keys.BottomNavKey
import com.glacirepower.tennisapp.navigation.navigator_provider.NavigationProvider
import com.glacirepower.tennisapp.navigation.root.AllGames
import com.glacirepower.tennisapp.navigation.root.Favorites
import com.glacirepower.tennisapp.navigation.root.Live
import com.glacirepower.tennisapp.navigation.root.News
import com.glacirepower.tennisapp.navigation.keys.RankingsKeys

class BottomNavProviderImp(
    private val addToBackStack: (RankingsKeys) -> Unit,
) : NavigationProvider {
    override fun provideEntry(key: NavKey): NavEntry<NavKey> {
        return when (key) {
            is BottomNavKey.Ranking -> NavEntry(key) {
                RankingScreen(onPlayerClick = { id, rank ->
                    addToBackStack(RankingsKeys.PlayerProfile(id, rank))
                })
            }

            is BottomNavKey.AllGames -> NavEntry(key) { AllGames() }
            is BottomNavKey.Live -> NavEntry(key) { Live() }
            is BottomNavKey.Favorites -> NavEntry(key) { Favorites() }
            is BottomNavKey.News -> NavEntry(key) { News() }

            else -> error("Unknown bottom navigation key: $key")
        }
    }
}
