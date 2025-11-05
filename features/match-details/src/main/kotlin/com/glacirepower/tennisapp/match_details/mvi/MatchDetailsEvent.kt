package com.glacirepower.tennisapp.match_details.mvi

import com.glacirepower.tennisapp.match_details.model.MatchDataModel
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticsModel
import mvi.Reducer

sealed interface MatchDetailsEvent : Reducer.ViewEvent {
    data object OnNavigateBack : MatchDetailsEvent
    data object OnEventDetailsLoaded : MatchDetailsEvent
    data class OnPointByPointLoaded(val pointByPoint: List<MatchDataModel>) : MatchDetailsEvent
    data class OnUpdateSet(val set: Int) : MatchDetailsEvent

    data class OnStatisticsLoaded(val statistics: StatisticsModel) : MatchDetailsEvent
}
