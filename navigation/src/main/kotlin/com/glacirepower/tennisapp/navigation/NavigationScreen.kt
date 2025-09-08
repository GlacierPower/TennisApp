package com.glacirepower.tennisapp.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.glacirepower.tennisapp.navigation.root.NavigationRoot
import theme.TennisTheme

@Composable
fun NavigationScreen() {
    val rankingBackStack = rememberNavBackStack(BottomNavKey.Ranking)
    val allGamesBackStack = rememberNavBackStack(BottomNavKey.AllGames)
    val liveGamesBackStack = rememberNavBackStack(BottomNavKey.Live)
    val favoritesBackStack = rememberNavBackStack(BottomNavKey.Favorites)
    val newsBackStack = rememberNavBackStack(BottomNavKey.News)

    var currentKey by rememberSaveable(stateSaver = BottomNavKey.stateSaver) {
        mutableStateOf(BottomNavKey.Ranking)
    }
    val currentBackStack = when (currentKey) {
        BottomNavKey.Ranking -> rankingBackStack
        BottomNavKey.AllGames -> allGamesBackStack
        BottomNavKey.Favorites -> favoritesBackStack
        BottomNavKey.Live -> liveGamesBackStack
        BottomNavKey.News -> newsBackStack
    }

    val addToBackStack: (NavKey) -> Unit = {
        when (currentKey) {
            BottomNavKey.Ranking -> rankingBackStack.add(it)
            BottomNavKey.AllGames -> allGamesBackStack.add(it)
            BottomNavKey.Favorites -> favoritesBackStack.add(it)
            BottomNavKey.Live -> liveGamesBackStack.add(it)
            BottomNavKey.News -> newsBackStack.add(it)
        }
    }
    val resetBackStack: (NavBackStack) -> Unit = {
        if (it.size > 1)
            it.removeRange(1, it.size)
    }

    val onHandleBackPressed: () -> Unit = {
        onBackPressed(
            currentBottomKey = currentKey,
            profileBackStackSize = allGamesBackStack.size,
            onSetHomeKey = {
                currentKey = BottomNavKey.Ranking
            },
            onPopHomeBackStack = { rankingBackStack.removeLastOrNull() },
            onPopAllGamesBackStack = { allGamesBackStack.removeLastOrNull() },
            onPopLiveBackStack = { liveGamesBackStack.removeLastOrNull() },
            onPopFavoritesBackStack = { favoritesBackStack.removeLastOrNull() },
            onPopNewsBackStack = { newsBackStack.removeLastOrNull() }
        )
    }

    Scaffold(
        bottomBar = {
            NavigationBar(modifier = Modifier.background(color = TennisTheme.colors.backgroundGlobe)) {
                BottomNavKey.items.forEach { key ->
                    NavigationBarItem(
                        selected = key == currentKey,
                        onClick = {
                            if (currentKey != key) {
                                currentKey = key
                            } else {
                                when (key) {
                                    BottomNavKey.Ranking -> resetBackStack(rankingBackStack)
                                    BottomNavKey.AllGames -> resetBackStack(allGamesBackStack)
                                    BottomNavKey.Favorites -> resetBackStack(favoritesBackStack)
                                    BottomNavKey.Live -> resetBackStack(liveGamesBackStack)
                                    BottomNavKey.News -> resetBackStack(newsBackStack)
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(key.iconResId),
                                contentDescription = null
                            )
                        },
                        label = { Text(text = stringResource(key.labelResId)) }
                    )
                }
            }
        }
    ) { _ ->
        NavigationRoot(
            modifier = Modifier.fillMaxSize(),
            addToBackStack = addToBackStack,
            currentBackStack = currentBackStack,
            onNavigateBack = onHandleBackPressed
        )
    }

    BackHandler(enabled = true) {
        onHandleBackPressed()
    }
}

private fun onBackPressed(
    currentBottomKey: BottomNavKey,
    profileBackStackSize: Int,
    onSetHomeKey: () -> Unit,
    onPopHomeBackStack: () -> Unit,
    onPopAllGamesBackStack: () -> Unit,
    onPopLiveBackStack: () -> Unit,
    onPopFavoritesBackStack: () -> Unit,
    onPopNewsBackStack: () -> Unit
) {
    when (currentBottomKey) {
        BottomNavKey.Ranking -> onPopHomeBackStack()
        BottomNavKey.AllGames -> onPopAllGamesBackStack()
        BottomNavKey.Favorites -> onPopFavoritesBackStack()
        BottomNavKey.Live -> onPopLiveBackStack
        BottomNavKey.News -> onPopNewsBackStack()
    }
}
