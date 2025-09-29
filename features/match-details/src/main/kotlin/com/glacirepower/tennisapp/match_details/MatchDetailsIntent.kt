package com.glacirepower.tennisapp.match_details

interface MatchDetailsIntent {
    fun onNavigateBack()
    fun onHomeTeamClick(id: String)
    fun onAwayTeamClick(id: String)
    fun onTournamentClick(id: String)
}
