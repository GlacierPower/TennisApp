package com.glacirepower.tennisapp.navigation.navigator_impl

import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsNavigator

class MatchDetailsNavigatorImp(
    private val onNavigateToPlayerDetails: (String) -> Unit,
    private val onNavigateToTournamentDetails: (String) -> Unit,
    private val onNavigateBack: () -> Unit
) : MatchDetailsNavigator {
    override fun navigateBack() {
        onNavigateBack()
    }

    override fun navigateToPlayerDetails(id: String) {
        onNavigateToPlayerDetails(id)
    }

    override fun navigateToTournamentDetails(id: String) {
        onNavigateToTournamentDetails(id)
    }
}
