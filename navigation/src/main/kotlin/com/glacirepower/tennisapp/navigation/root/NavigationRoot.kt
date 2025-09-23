package com.glacirepower.tennisapp.navigation.root

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.glacirepower.tennisapp.navigation.navigation_provider_impl.BottomNavProviderImp
import com.glacirepower.tennisapp.navigation.navigation_provider_impl.RankingNavProvider
import com.glacirepower.tennisapp.navigation.navigator_provider.CompositeNavigationProvider
import theme.TennisTheme

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    addToBackStack: (NavKey) -> Unit,
    currentBackStack: List<NavKey>,
    onNavigateBack: () -> Unit
) {
    val currentTheme = TennisTheme.colors
    val navigationProvider = remember(currentTheme) {
        CompositeNavigationProvider(
            listOf(
                BottomNavProviderImp(addToBackStack = { addToBackStack(it) }),
                RankingNavProvider(
                    addToBackStack = { addToBackStack(it) },
                    onNavigateBack = onNavigateBack
                )
            )
        )
    }

    NavDisplay(
        modifier = modifier,
        backStack = currentBackStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { key ->
            navigationProvider.provideEntry(key)
        },
        transitionSpec = {
            fadeIn(tween(300)) togetherWith fadeOut(tween(300))
        },
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
