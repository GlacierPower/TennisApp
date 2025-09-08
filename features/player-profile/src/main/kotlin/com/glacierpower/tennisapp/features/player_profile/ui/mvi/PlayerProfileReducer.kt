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
                    playerSummaries = event.summaries.summaries.map { it.toSummariesDvo(previousState.playerId) },
                    isLoading = false
                ) to null
            }

            is PlayerProfileEvent.OnUpdatePlayerData -> previousState.copy(playerId = event.playerId, rank = event.rank) to null
        }
    }
}
