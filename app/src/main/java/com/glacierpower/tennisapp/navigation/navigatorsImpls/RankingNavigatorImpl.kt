package com.glacierpower.tennisapp.navigation.navigatorsImpls

import androidx.navigation.NavController
import com.glacierpower.tennisapp.features.ranking.navigation.RankingNavigator
import com.glacierpower.tennisapp.features.ranking.ui.RankingFragmentDirections
import javax.inject.Inject

class RankingNavigatorImpl @Inject constructor(
    private val navController: NavController
) : RankingNavigator {
    override fun navigateToProfile(id: String, rank: String) {
        val directions =
            RankingFragmentDirections.actionRankingFragmentToPlayerDetailsFragment(id, rank)
        navController.navigate(directions)
    }
}
