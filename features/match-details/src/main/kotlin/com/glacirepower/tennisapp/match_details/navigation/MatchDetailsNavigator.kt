package com.glacirepower.tennisapp.match_details.navigation

interface MatchDetailsNavigator {
    fun navigateBack()

    fun navigateToPlayerDetails(id: String)
}
