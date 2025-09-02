package com.glacierpower.tennisapp.features.ranking.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import com.glacierpower.tennisapp.domain.ranking.use_cases.GetRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import network.tennisResult.TennisResult
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getRankingUseCase: GetRankingUseCase
) : ViewModel() {

    init {
        getRanking()
    }

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _ranking = MutableLiveData<List<RankingModel>>()
    val ranking: LiveData<List<RankingModel>> get() = _ranking

    fun getRanking() {
        viewModelScope.launch {
            when (val result = getRankingUseCase()) {
                is TennisResult.Error -> {
                }

                is TennisResult.Success -> {
                    _ranking.value = result.data
                    _isLoading.value = false
                    _connection.value = false
                }
            }
        }
    }
}
