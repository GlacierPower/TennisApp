package com.glacirepower.tennisapp.match_details.mvi

import mvi.Reducer

sealed interface MatchDetailsEvent : Reducer.ViewEvent {
    data object OnNavigateBack : MatchDetailsEvent
    data object OnEventDetailsLoaded : MatchDetailsEvent
}
