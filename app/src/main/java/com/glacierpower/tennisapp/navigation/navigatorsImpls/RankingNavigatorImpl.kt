
package com.glacierpower.tennisapp.navigation.navigatorsImpls

import androidx.navigation.NavController
import com.glacierpower.tennisapp.presentation.ranking.RankingFragmentDirections
import com.glacierpower.tennisapp.presentation.ranking.com.glacierpower.tennisapp.features.ranking.adapter.navigation.RankingNavigator
import javax.inject.Inject

class RankingNavigatorImpl @Inject constructor(
    private val navController: NavController
) : RankingNavigator {
    override fun navigateToProfile(id: String) {
        val directions = RankingFragmentDirections.actionRankingFragmentToPlayerDetailsFragment(id)
        navController.navigate(directions)
    }
}
