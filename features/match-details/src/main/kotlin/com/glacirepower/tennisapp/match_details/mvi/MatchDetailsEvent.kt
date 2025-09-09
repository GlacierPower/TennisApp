package com.glacirepower.tennisapp.match_details.mvi

import model.player_summaries.SummariesModel
import mvi.Reducer

sealed interface MatchDetailsEvent : Reducer.ViewEvent {
    data object OnNavigateBack : MatchDetailsEvent
    data class OnEventDetailsLoaded(val summariesModel: SummariesModel) : MatchDetailsEvent
}
