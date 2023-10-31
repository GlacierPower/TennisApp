package com.glacierpower.tennisapp.presentation.player_details

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.palyer_details.PlayerDetailsInteractor
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.InternetConnection
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PlayerDetailsViewModel @Inject constructor(private val playerDetailsInteractor: PlayerDetailsInteractor) :
    ViewModel() {

    @Inject
    lateinit var internetConnection: InternetConnection

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _playerDetails = MutableLiveData<ResultState<PlayerDetailsModel>>()
    val playerDetails: LiveData<ResultState<PlayerDetailsModel>> get() = _playerDetails

    private var _playerNearEvents = MutableLiveData<ResultState<PlayerNearEventsModel>>()
    val playerNearEvents: LiveData<ResultState<PlayerNearEventsModel>> get() = _playerNearEvents

    private val _playerLastEvents = MutableLiveData<ResultState<List<LastEventModel>>>()
    val playerLastEvents: LiveData<ResultState<List<LastEventModel>>> get() = _playerLastEvents

    private var _nearEventLayout = MutableLiveData<Int>()
    val nearEventLayout: LiveData<Int> get() = _nearEventLayout


    private var _convertTime = MutableLiveData<Long?>()
    val convertTime: LiveData<Long?> get() = _convertTime


    fun getPlayerDetails(id: Int) {
        _playerDetails.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val response = playerDetailsInteractor.getPlayerDetails(id)
                    _playerDetails.value = response
                    _connection.value = false
                } else {
                    _connection.value = true
                    _playerDetails.postValue(ResultState.Error(Constants.NO_CONNECTION))

                }
            } catch (exception: Exception) {
                when (exception) {
//                    is IOException -> _playerDetails.postValue(ResultState.Error(exception.message!!))
                }
            }
        }
    }

    fun getPlayerNearEvents(id: Int) {
        _playerNearEvents.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val response = playerDetailsInteractor.getPlayerNearEvents(id)
                    if(response.data!!.nextEvent!=null){
                        _playerNearEvents.value = response
                        _convertTime.value = response.data.nextEvent?.startTimestamp
                        _connection.value = false
                    }else{
                        _nearEventLayout.value = View.GONE
                    }
                } else {
                    _connection.value = true
                    _playerNearEvents.postValue(ResultState.Error(Constants.NO_CONNECTION))

                }
            } catch (exception: Exception) {
                when (exception) {
                    is NullPointerException -> _nearEventLayout.value = View.GONE
                }
            }
        }
    }

    fun getPlayerLastEvents(id: Int) {
        _playerDetails.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    val response = playerDetailsInteractor.getPlayerLastEvents(id)
                    _playerLastEvents.value = response
                    _connection.value = false

                } else {
                    _connection.value = true
                    _playerLastEvents.postValue(ResultState.Error(Constants.NO_CONNECTION))
                }

            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> _playerNearEvents.postValue(ResultState.Error(exception.message!!))

                }
            }
        }

    }
}
