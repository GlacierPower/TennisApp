package com.glacierpower.tennisapp.domain.event_details

import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class EventDetailsInteractor @Inject constructor(private val eventDetailsRepository: EventDetailsRepository) {

    suspend fun getEventDetails(id: Int): ResultState<EventDetailsModel> {
        return eventDetailsRepository.getEventDetails(id)
    }

}