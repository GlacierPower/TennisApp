package com.glacirepower.tennisapp.match_details.mvi

import mvi.Reducer
import javax.inject.Inject

class MatchDetailsReducer @Inject constructor() :
    Reducer<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect> {
    override fun reduce(
        previousState: MatchDetailsState,
        event: MatchDetailsEvent
    ): Pair<MatchDetailsState, MatchDetailsEffect?> {
        return when (event) {
            MatchDetailsEvent.OnNavigateBack -> previousState to MatchDetailsEffect.NavigateBack
            is MatchDetailsEvent.OnEventDetailsLoaded -> previousState.copy(
                summariesModel = event.summariesModel,
                isLoading = false
            ) to null
        }
    }
}
