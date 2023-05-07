package com.glacierpower.tennisapp.ui.ranking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.RankingInteractor
import com.glacierpower.tennisapp.model.RankingModel
import com.glacierpower.tennisapp.utils.Constants.NO_CONNECTION
import com.glacierpower.tennisapp.utils.InternetConnection
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val rankingInteractor: RankingInteractor
) : ViewModel() {

    @Inject
    lateinit var internetConnection: InternetConnection

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _ranking = MutableLiveData<ResultState<List<RankingModel>>>()
    val ranking: LiveData<ResultState<List<RankingModel>>> get() = _ranking

    fun getAtpRanking() {
        _ranking.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val response = rankingInteractor.getAtpRanking()
                    _ranking.value = response
                    _connection.value = false
                } else {
                    _connection.value = true
                    _ranking.postValue(ResultState.Error(NO_CONNECTION))

                }
            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> _ranking.postValue(ResultState.Error(exception.message!!))
                }
            }
        }
    }

    fun getWtaRanking() {
        _ranking.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val response = rankingInteractor.getWtaRanking()
                    _ranking.value = response
                    _connection.value = false
                }else{
                    _connection.value = true
                    _ranking.postValue(ResultState.Error(NO_CONNECTION))
                }
            } catch (exception: Exception){
                when (exception) {
                    is IOException -> _ranking.postValue(ResultState.Error(exception.message!!))
                }
            }
        }
    }
}