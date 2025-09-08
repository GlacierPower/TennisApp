package com.glacirepower.tennisapp.navigation.root

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileScreen
import com.glacierpower.tennisapp.features.player_profile.args.ProfileArgs
import com.glacierpower.tennisapp.features.ranking.ui.compose.RankingScreen
import com.glacirepower.tennisapp.navigation.BottomNavKey
import com.glacirepower.tennisapp.navigation.screens.ScreensKey

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    addToBackStack: (NavKey) -> Unit,
    currentBackStack: List<NavKey>,
    onNavigateBack: () -> Unit
) {
    NavDisplay(
        modifier = modifier,
        backStack = currentBackStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is BottomNavKey.Ranking -> {
                    NavEntry(
                        key = key,
                    ) {
                        RankingScreen(onPlayerClick = { id, rank ->
                            addToBackStack(ScreensKey.PlayerProfile(id, rank))
                        })
                    }
                }

                is BottomNavKey.AllGames -> {
                    NavEntry(
                        key = key
                    ) {
                        AllGames()
                    }
                }

                is BottomNavKey.Live -> {
                    NavEntry(
                        key = key,
                    ) {
                        Live()
                    }
                }

                is BottomNavKey.Favorites -> {
                    NavEntry(
                        key = key,
                    ) {
                        Favorites()
                    }
                }

                is BottomNavKey.News -> {
                    NavEntry(
                        key = key,
                    ) {
                        News()
                    }
                }

                is ScreensKey.PlayerProfile -> {
                    NavEntry(
                        key = key
                    ) {
                        PlayerProfileScreen(
                            onNavigateBack = { onNavigateBack() },
                            args = ProfileArgs(
                                id = key.id,
                                rank = key.rank
                            )
                        )
                    }
                }

                else -> {
                    error("Unknown navigation key: $key")
                }
            }
        }
    )
}

@Composable
fun AllGames() {
    Text("All games")
}

@Composable
fun Live() {
    Text("LIve")
}

@Composable
fun Favorites() {
    Text("Favorites")
}

@Composable
fun News() {
    Text("News")
}
