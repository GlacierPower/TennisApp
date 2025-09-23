package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import model.common.country_flag.Country
import models.player_details.details.PlayerDetailsModel
import models.player_details.events.PlayerEventsDataModel
import mvi.Reducer

sealed interface PlayerProfileEvent : Reducer.ViewEvent {
    data class OnPlayerInfoLoaded(
        val profile: PlayerDetailsModel,
    ) : PlayerProfileEvent

    data class OnUpdatePlayerData(val playerId: String?) : PlayerProfileEvent
    data class OnUpdateCountryFlag(val flags: List<Country>) : PlayerProfileEvent

    data class OnPlayerEventsLoaded(val events: List<PlayerEventsDataModel>) : PlayerProfileEvent
}
