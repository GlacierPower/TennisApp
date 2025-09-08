package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import androidx.compose.runtime.Immutable
import com.glacierpower.tennisapp.features.player_profile.model.SummariesDvo
import models.PlayerProfileModel
import mvi.Reducer

@Immutable
data class PlayerProfileState(
    val isLoading: Boolean = true,
    val playerId: String? = null,
    val playerSummaries: List<SummariesDvo> = emptyList(),
    val playerProfile: PlayerProfileModel? = null,
    val rank: String? = null,
    val isWin: Boolean = false
) : Reducer.ViewState
