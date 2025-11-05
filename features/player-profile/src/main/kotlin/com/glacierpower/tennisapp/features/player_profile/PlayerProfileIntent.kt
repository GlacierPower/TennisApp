package com.glacierpower.tennisapp.features.player_profile

interface PlayerProfileIntent {
    fun onNavigateBack()
    fun onNavigateToMatchDetails(eventId: String)
}
