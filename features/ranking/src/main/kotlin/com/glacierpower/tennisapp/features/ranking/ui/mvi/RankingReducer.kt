package com.glacierpower.tennisapp.features.ranking.ui.mvi

import mvi.Reducer
import javax.inject.Inject

class RankingReducer @Inject constructor() : Reducer<RankingState, RankingEvent, RankingEffect> {
    override fun reduce(
        previousState: RankingState,
        event: RankingEvent
    ): Pair<RankingState, RankingEffect?> {
        return when (event) {
            RankingEvent.OnNavigateToProfile -> previousState to null
            is RankingEvent.OnGetRankings -> previousState.copy(
                ranking = event.rankings,
                isLoading = false
            ) to null
        }
    }
}
