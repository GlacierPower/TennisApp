package com.glacierpower.tennisapp.presentation.event_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.event_details.EventDetailsInteractor
import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.utils.Constants
import com.glacierpower.tennisapp.utils.InternetConnection
import com.glacierpower.tennisapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class EventDetailsViewModel @Inject constructor(private val eventDetailsInteractor: EventDetailsInteractor) :
    ViewModel() {

    @Inject
    lateinit var internetConnection: InternetConnection

    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _eventDetails = MutableLiveData<ResultState<EventDetailsModel>>()
    val eventDetails: LiveData<ResultState<EventDetailsModel>> get() = _eventDetails

    private var _convertTime = MutableLiveData<Long?>()
    val convertTime: LiveData<Long?> get() = _convertTime

    fun getEventDetails(id: Int) {
        _eventDetails.postValue(ResultState.Loading())
        viewModelScope.launch {
            try {
                if (internetConnection.isOnline()) {
                    while (true) {
                        val response = eventDetailsInteractor.getEventDetails(id)
                        _eventDetails.value = response
                        _convertTime.value = response.data?.startTimestamp
                        _connection.value = false
                        delay(5000)
                    }

                } else {
                    _connection.value = true
                    _eventDetails.postValue(ResultState.Error(Constants.NO_CONNECTION))
                }
            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> _eventDetails.postValue(ResultState.Error(exception.message!!))
                }

            }
        }
    }
}

