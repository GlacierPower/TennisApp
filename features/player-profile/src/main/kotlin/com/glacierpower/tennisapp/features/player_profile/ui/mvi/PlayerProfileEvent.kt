package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import models.PlayerProfileModel
import models.player_summaries.PlayerSummariesModel
import mvi.Reducer

sealed interface PlayerProfileEvent : Reducer.ViewEvent {
    data class OnPlayerInfoLoaded(
        val profile: PlayerProfileModel?,
        val summaries: PlayerSummariesModel
    ) : PlayerProfileEvent

    data class OnUpdatePlayerData(val playerId: String?, val rank: String?) : PlayerProfileEvent
}
