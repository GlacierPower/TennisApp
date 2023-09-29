package com.glacierpower.tennisapp.presentation.live_events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.events.LiveEventInteractor
import com.glacierpower.tennisapp.model.eventModel.EventModel
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.InternetConnection
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LiveEventViewModel @Inject constructor(
    private val liveEventInteractor: LiveEventInteractor
) : ViewModel() {

    @Inject
    lateinit var internetConnection: InternetConnection

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _liveEvent = MutableLiveData<ResultState<List<EventModel>>>()
    val liveEvent: LiveData<ResultState<List<EventModel>>> get() = _liveEvent

    fun getLiveEvent() {
        _liveEvent.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                    if (internetConnection.isOnline()) {
                        while (true) {
                            val response = liveEventInteractor.getLiveEvent()
                            _liveEvent.value = response
                            _connection.value = false
                            delay(10000)
                        }
                    } else {
                        _connection.value = true
                        _liveEvent.postValue(ResultState.Error(Constants.NO_CONNECTION))
                   delay(30000) }

            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> _liveEvent.postValue(ResultState.Error(exception.message!!))
                }
            }

        }
    }

}

