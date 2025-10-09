package com.glacierpower.tennisapp.feature.tournament_details.mvi

import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsEffect.*
import mvi.Reducer
import javax.inject.Inject

class TournamentDetailsReducer @Inject constructor() :
    Reducer<TournamentDetailsState, TournamentDetailsEvent, TournamentDetailsEffect> {
    override fun reduce(
        previousState: TournamentDetailsState,
        event: TournamentDetailsEvent
    ): Pair<TournamentDetailsState, TournamentDetailsEffect?> {
        return when (event) {
            is TournamentDetailsEvent.OnNavigateToPlayerDetails -> previousState to NavigateToPlayerDetails(
                event.id
            )

            is TournamentDetailsEvent.OnTournamentDateLoaded -> previousState.copy(tournament = event.tournament) to null
        }
    }
}
