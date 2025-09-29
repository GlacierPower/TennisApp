package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import kotlinx.serialization.InternalSerializationApi
import model.common.country_flag.Country
import model.events.PlayerEventsDataModel
import models.player_details.details.PlayerDetailsModel
import mvi.Reducer

@InternalSerializationApi
sealed interface PlayerProfileEvent : Reducer.ViewEvent {
    data class OnPlayerInfoLoaded(
        val profile: PlayerDetailsModel,
    ) : PlayerProfileEvent

    data class OnUpdatePlayerData(val playerId: String?) : PlayerProfileEvent
    data class OnUpdateCountryFlag(val flags: List<Country>) : PlayerProfileEvent

    data class OnPlayerEventsLoaded(val events: List<PlayerEventsDataModel>) : PlayerProfileEvent

    data class OnNavigateToMatchDetails(val eventId: String) : PlayerProfileEvent
}
