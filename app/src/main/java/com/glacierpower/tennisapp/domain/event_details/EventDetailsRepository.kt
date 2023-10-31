package com.glacierpower.tennisapp.domain.event_details

import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.utils.ResultState

interface EventDetailsRepository {
    suspend fun getEventDetails(id:Int):ResultState<EventDetailsModel>
}