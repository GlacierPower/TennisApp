package com.glacierpower.tennisapp.features.player_profile.ui.mvi

import mvi.Reducer
import javax.inject.Inject

class PlayerProfileReducer @Inject constructor() :
    Reducer<PlayerProfileState, PlayerProfileEvent, PlayerProfileEffect> {
    override fun reduce(
        previousState: PlayerProfileState,
        event: PlayerProfileEvent
    ): Pair<PlayerProfileState, PlayerProfileEffect?> {
        return when (event) {
            is PlayerProfileEvent.OnPlayerInfoLoaded -> previousState.copy(
                playerProfile = event.profile,
                playerSummaries = event.summaries,
                isLoading = false
            ) to null
        }
    }
}
