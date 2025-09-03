
package com.glacierpower.tennisapp.features.ranking.ui.mvi

import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import mvi.Reducer

sealed interface RankingEvent : Reducer.ViewEvent {
    data object OnNavigateToProfile : RankingEvent
    data class OnGetRankings(val rankings: List<RankingModel>) : RankingEvent
}
