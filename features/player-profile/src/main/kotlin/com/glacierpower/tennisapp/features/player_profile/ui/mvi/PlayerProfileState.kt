package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import androidx.compose.runtime.Immutable
import com.glacierpower.tennisapp.features.player_profile.model.PlayerEventDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import models.player_details.details.PlayerDetailsModel
import mvi.Reducer
import java.net.URL

@InternalSerializationApi
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
    val eventModel: List<PlayerEventsDataModel> = emptyList(),
    val isAwayWin: Boolean = false
) : Reducer.ViewState
