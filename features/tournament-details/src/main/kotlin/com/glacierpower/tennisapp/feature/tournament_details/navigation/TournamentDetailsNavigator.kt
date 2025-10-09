package com.glacierpower.tennisapp.feature.tournament_details.navigation

interface TournamentDetailsNavigator {
    fun navigateBack()
    fun navigateToPlayerDetails(id: String)
}
