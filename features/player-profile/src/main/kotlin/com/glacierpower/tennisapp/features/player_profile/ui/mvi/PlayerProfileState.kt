package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import androidx.compose.runtime.Immutable
import com.glacierpower.tennisapp.features.player_profile.model.PlayerEventDvo
import models.player_details.details.PlayerDetailsModel
import mvi.Reducer
import java.net.URL

@Immutable
data class PlayerProfileState(
    val isLoading: Boolean = true,
    val playerId: String? = null,
    val playerProfile: PlayerDetailsModel? = null,
    val rank: String? = null,
    val isWin: Boolean = false,
    val flagUrl: URL? = null,
    val events: List<PlayerEventDvo> = emptyList(),
    val isHomeWin: Boolean = false,
    val isAwayWin: Boolean = false
) : Reducer.ViewState
