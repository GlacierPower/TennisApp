package com.glacierpower.tennisapp.feature.tournament_details.composable

import androidx.compose.runtime.Composable
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.feature.tournament_details.TournamentDetailsIntent
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsState

@Composable
fun TournamentDetailsContent(
    state: TournamentDetailsState,
    intentListener: TournamentDetailsIntent
) {
    TennisAppText(text = state.tournament.toString()) // Todo create ui
}
