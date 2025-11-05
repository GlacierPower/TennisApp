package com.glacierpower.tennisapp.features.ranking.ui.mvi

import androidx.compose.runtime.Immutable
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import model.common.country_flag.Country
import mvi.Reducer

@Immutable
data class RankingState(
    val isLoading: Boolean = true,
    val ranking: List<RankingModel> = emptyList(),
    val flags: List<Country> = emptyList()
) : Reducer.ViewState
