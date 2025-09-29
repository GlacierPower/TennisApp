package com.glacirepower.tennisapp.match_details.mvi

import mvi.Reducer

sealed interface MatchDetailsEffect : Reducer.ViewEffect {
    data object NavigateBack : MatchDetailsEffect

    data class NavigateToPlayerDetails(val playerId: String) : MatchDetailsEffect
}
