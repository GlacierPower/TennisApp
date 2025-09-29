package com.glacierpower.tennisapp.features.ranking.ui.mvi

import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import model.common.country_flag.Country
import mvi.Reducer

sealed interface RankingEvent : Reducer.ViewEvent {
    data object OnNavigateToProfile : RankingEvent
    data class OnGetRankings(val rankings: List<RankingModel>) : RankingEvent

    data class OnGetCountryFlags(val flags: List<Country>) : RankingEvent
}
