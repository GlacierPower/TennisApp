package com.glacirepower.tennisapp.match_details.mvi

import com.glacirepower.tennisapp.match_details.mappers.toScoreDvo
import kotlinx.serialization.InternalSerializationApi
import mvi.Reducer
import javax.inject.Inject

@InternalSerializationApi
class MatchDetailsReducer @Inject constructor() :
    Reducer<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect> {
    override fun reduce(
        previousState: MatchDetailsState,
        event: MatchDetailsEvent
    ): Pair<MatchDetailsState, MatchDetailsEffect?> {
        return when (event) {
            MatchDetailsEvent.OnNavigateBack -> previousState to MatchDetailsEffect.NavigateBack
            is MatchDetailsEvent.OnEventDetailsLoaded -> {
                previousState.copy(
                    scoreDvo = previousState.event?.toScoreDvo(),
                    isLoading = false
                ) to null
            }
        }
    }
}
