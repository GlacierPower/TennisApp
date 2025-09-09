package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import model.player_summaries.PlayerSummariesModel
import models.PlayerProfileModel
import mvi.Reducer

sealed interface PlayerProfileEvent : Reducer.ViewEvent {
    data class OnPlayerInfoLoaded(
        val profile: PlayerProfileModel?,
        val summaries: PlayerSummariesModel
    ) : PlayerProfileEvent

    data class OnUpdatePlayerData(val playerId: String?, val rank: String?) : PlayerProfileEvent
}
