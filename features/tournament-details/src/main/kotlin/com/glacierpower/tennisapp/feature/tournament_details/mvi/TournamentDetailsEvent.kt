package com.glacierpower.tennisapp.feature.tournament_details.mvi

import com.glacierpower.tennisapp.domain.tournament_details.model.MatchModel
import mvi.Reducer

sealed interface TournamentDetailsEvent : Reducer.ViewEvent {
    data class OnNavigateToPlayerDetails(val id: String) : TournamentDetailsEvent
    data class OnTournamentDateLoaded(val tournament: List<MatchModel>) : TournamentDetailsEvent
}
