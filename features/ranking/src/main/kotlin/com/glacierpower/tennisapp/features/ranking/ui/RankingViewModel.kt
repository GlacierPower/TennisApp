package com.glacierpower.tennisapp.features.ranking.ui

import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.ranking.use_cases.GetRankingUseCase
import com.glacierpower.tennisapp.features.ranking.ui.mvi.RankingEffect
import com.glacierpower.tennisapp.features.ranking.ui.mvi.RankingEvent
import com.glacierpower.tennisapp.features.ranking.ui.mvi.RankingReducer
import com.glacierpower.tennisapp.features.ranking.ui.mvi.RankingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mvi.BaseViewModel
import network.tennisResult.TennisResult
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getRankingUseCase: GetRankingUseCase
) : BaseViewModel<RankingState, RankingEvent, RankingEffect>(
    initialState = RankingState(),
    reducer = RankingReducer()
) {

    init {
        getRanking()
    }

    fun getRanking() {
        viewModelScope.launch {
            when (val result = getRankingUseCase()) {
                is TennisResult.Error -> {
                }

                is TennisResult.Success -> {
                    sendEvent(RankingEvent.OnGetRankings(result.data))
                }
            }
        }
    }
}
