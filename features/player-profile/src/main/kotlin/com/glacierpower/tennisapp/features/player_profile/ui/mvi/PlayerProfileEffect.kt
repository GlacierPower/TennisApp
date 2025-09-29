package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import mvi.Reducer

@InternalSerializationApi
sealed interface PlayerProfileEffect : Reducer.ViewEffect {
    data object NavigateBack : PlayerProfileEffect
    data class NavigateToMatchDetails(val eventsDataModel: PlayerEventsDataModel?) :
        PlayerProfileEffect
}
