package com.glacirepower.tennisapp.match_details.mvi

import androidx.compose.runtime.Immutable
import model.player_summaries.SummariesModel
import mvi.Reducer

@Immutable
data class MatchDetailsState(
    val isLoading: Boolean = true,
    val summariesModel: SummariesModel? = null
) : Reducer.ViewState
