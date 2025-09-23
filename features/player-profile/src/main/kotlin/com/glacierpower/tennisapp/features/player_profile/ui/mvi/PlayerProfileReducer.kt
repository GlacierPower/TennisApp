package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import com.glacierpower.tennisapp.features.player_profile.model.toSummariesDvo
import mvi.Reducer
import javax.inject.Inject

class PlayerProfileReducer @Inject constructor() :
    Reducer<PlayerProfileState, PlayerProfileEvent, PlayerProfileEffect> {
    override fun reduce(
        previousState: PlayerProfileState,
        event: PlayerProfileEvent
    ): Pair<PlayerProfileState, PlayerProfileEffect?> {
        return when (event) {
            is PlayerProfileEvent.OnPlayerInfoLoaded -> {
                previousState.copy(
                    playerProfile = event.profile,
                    isLoading = false
                ) to null
            }

            is PlayerProfileEvent.OnUpdatePlayerData -> previousState.copy(playerId = event.playerId) to null
            is PlayerProfileEvent.OnUpdateCountryFlag -> {
                val flagUrl = event.flags.find {
                    it.name == previousState.playerProfile?.country
                }?.flagUrl
                previousState.copy(flagUrl = flagUrl) to null
            }

            is PlayerProfileEvent.OnPlayerEventsLoaded -> previousState.copy(
                events = event.events.map { it.toSummariesDvo(previousState.playerId.orEmpty()) },
            ) to null
        }
    }
}
