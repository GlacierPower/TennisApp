package com.glacierpower.tennisapp.feature.tournament_details.mvi

import mvi.Reducer

sealed interface TournamentDetailsEffect : Reducer.ViewEffect {
    data object NavigateBack : TournamentDetailsEffect
    data class NavigateToPlayerDetails(val id: String) : TournamentDetailsEffect
}
