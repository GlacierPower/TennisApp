package com.glacierpower.tennisapp.features.ranking.ui.mvi

import com.glacierpower.tennisapp.features.ranking.utils.updateRankingsWithFlags
import mvi.Reducer
import javax.inject.Inject

class RankingReducer @Inject constructor() : Reducer<RankingState, RankingEvent, RankingEffect> {
    override fun reduce(
        previousState: RankingState,
        event: RankingEvent
    ): Pair<RankingState, RankingEffect?> {
        return when (event) {
            RankingEvent.OnNavigateToProfile -> previousState to null
            is RankingEvent.OnGetRankings -> {
                val updatedRankings = updateRankingsWithFlags(
                    event.rankings,
                    previousState.flags
                )
                previousState.copy(
                    ranking = updatedRankings,
                    isLoading = false
                ) to null
            }

            is RankingEvent.OnGetCountryFlags -> previousState.copy(
                flags = event.flags
            ) to null
        }
    }
}
