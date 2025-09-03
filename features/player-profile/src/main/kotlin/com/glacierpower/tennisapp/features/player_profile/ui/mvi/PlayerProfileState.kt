package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import androidx.compose.runtime.Immutable
import models.PlayerProfileModel
import models.player_summaries.PlayerSummariesModel
import mvi.Reducer

@Immutable
data class PlayerProfileState(
    val isLoading: Boolean = true,
    val playerId: String?,
    val playerSummaries: PlayerSummariesModel? = null,
    val playerProfile: PlayerProfileModel? = null
) : Reducer.ViewState {
    companion object {
        fun initial(playerId: String?): PlayerProfileState {
            return PlayerProfileState(
                playerId = playerId
            )
        }
    }
}
