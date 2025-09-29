package com.glacirepower.tennisapp.navigation.navigation_provider_impl

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileScreen
import com.glacierpower.tennisapp.features.player_profile.args.ProfileArgs
import com.glacirepower.tennisapp.match_details.MatchDetailsScreen
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsArgs
import com.glacirepower.tennisapp.navigation.keys.RankingsKeys
import com.glacirepower.tennisapp.navigation.navigator_impl.MatchDetailsNavigatorImp
import com.glacirepower.tennisapp.navigation.navigator_provider.NavigationProvider
import kotlinx.serialization.InternalSerializationApi

@InternalSerializationApi
class RankingNavProvider(
    private val addToBackStack: (RankingsKeys) -> Unit,
    private val onNavigateBack: () -> Unit
) : NavigationProvider {
    override fun provideEntry(key: NavKey): NavEntry<NavKey> {
        return when (key) {
            is RankingsKeys.PlayerProfile -> NavEntry(key) {
                PlayerProfileScreen(
                    onNavigateBack = { onNavigateBack() },
                    onNavigateToDetails = { event ->
                        addToBackStack(RankingsKeys.MatchDetails(event))
                    },
                    args = ProfileArgs(id = key.id)
                )
            }

            is RankingsKeys.MatchDetails -> NavEntry(key) {
                val matchNavigator = MatchDetailsNavigatorImp(
                    onNavigateToPlayerDetails = { addToBackStack(RankingsKeys.PlayerProfile(it)) },
                    onNavigateBack = { onNavigateBack() }
                )
                MatchDetailsScreen(
                    MatchDetailsArgs(event = key.event),
                    navigator = matchNavigator,
                )
            }

            else -> error("Unknown screen key: $key")
        }
    }
}
