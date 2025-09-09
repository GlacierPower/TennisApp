package com.glacierpower.tennisapp.features.ranking.ui.mvi

import androidx.compose.runtime.Immutable
import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import mvi.Reducer

@Immutable
data class RankingState(
    val isLoading: Boolean = true,
    val ranking: List<RankingModel> = emptyList(),
    val flagUri: String = ""
) : Reducer.ViewState
