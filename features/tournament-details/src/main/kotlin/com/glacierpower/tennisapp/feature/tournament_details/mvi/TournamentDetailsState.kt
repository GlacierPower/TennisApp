package com.glacierpower.tennisapp.feature.tournament_details.mvi

import com.glacierpower.tennisapp.domain.tournament_details.model.MatchModel
import mvi.Reducer

data class TournamentDetailsState(
    val isLoading: Boolean = true,
    val tournament: List<MatchModel> = emptyList()
) : Reducer.ViewState
