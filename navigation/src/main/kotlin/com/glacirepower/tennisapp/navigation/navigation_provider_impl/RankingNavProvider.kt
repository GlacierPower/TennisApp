package com.glacirepower.tennisapp.navigation.navigation_provider_impl

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileScreen
import com.glacierpower.tennisapp.features.player_profile.args.ProfileArgs
import com.glacirepower.tennisapp.match_details.MatchDetailsScreen
import com.glacirepower.tennisapp.navigation.keys.RankingsKeys
import com.glacirepower.tennisapp.navigation.navigator_provider.NavigationProvider

class RankingNavProvider(
    private val addToBackStack: (RankingsKeys) -> Unit,
    private val onNavigateBack: () -> Unit
) : NavigationProvider {
    override fun provideEntry(key: NavKey): NavEntry<NavKey> {
        return when (key) {
            is RankingsKeys.PlayerProfile -> NavEntry(key) {
                PlayerProfileScreen(
                    onNavigateBack = { onNavigateBack() },
                    onNavigateToDetails = { eventId ->
                        addToBackStack(RankingsKeys.MatchDetails(eventId))
                    },
                    args = ProfileArgs(id = key.id, rank = key.rank)
                )
            }

            is RankingsKeys.MatchDetails -> NavEntry(key) {
                MatchDetailsScreen()
            }

            else -> error("Unknown screen key: $key")
        }
    }
}
