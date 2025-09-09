package com.glacirepower.tennisapp.navigation.keys

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import com.glacierpower.tennisapp.navigation.R
import kotlinx.serialization.Serializable

sealed interface BottomNavKey : NavKey {
    val iconResId: Int
    val labelResId: Int

    @Serializable
    data object AllGames : BottomNavKey {
        override val iconResId: Int = R.drawable.ic_all_games
        override val labelResId: Int = R.string.navigation_all_games
    }

    @Serializable
    data object Live : BottomNavKey {
        override val iconResId: Int = R.drawable.ic_live_matches
        override val labelResId: Int = R.string.navigation_live
    }

    @Serializable
    data object Favorites : BottomNavKey {
        override val iconResId: Int = R.drawable.ic_favorite
        override val labelResId: Int = R.string.navigation_favorites
    }

    @Serializable
    data object News : BottomNavKey {
        override val iconResId: Int = R.drawable.ic_news
        override val labelResId: Int = R.string.navigation_news
    }

    @Serializable
    data object Ranking : BottomNavKey {
        override val iconResId: Int = R.drawable.ic_ratting
        override val labelResId: Int = R.string.navigation_ranking
    }

    companion object {

        val items = listOf(Ranking, AllGames, Live, Favorites, News)

        val stateSaver = Saver<BottomNavKey, String>(
            save = { it::class.qualifiedName },
            restore = { qualifiedClass ->
                items.firstOrNull { it::class.qualifiedName == qualifiedClass }
            }
        )
    }
}
