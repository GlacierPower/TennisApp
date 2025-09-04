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
                    playerSummaries = event.summaries.summaries.map { it.toSummariesDvo() },
                    isLoading = false
                ) to null
            }
        }
    }
}
