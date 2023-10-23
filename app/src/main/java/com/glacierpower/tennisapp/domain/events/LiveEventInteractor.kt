package com.glacierpower.tennisapp.domain.events

import com.glacierpower.tennisapp.model.eventModel.EventModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class LiveEventInteractor @Inject constructor(
    private val liveEventsRepository: LiveEventsRepository
) {
    suspend fun getLiveEvent(): ResultState<List<EventModel>> {
        return liveEventsRepository.getLiveEvent()
    }

    suspend fun getCountryFlag(code:String){
        return liveEventsRepository.getCountryFlag(code)
    }
}