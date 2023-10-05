package com.glacierpower.tennisapp.domain.events

import com.glacierpower.tennisapp.model.eventModel.EventModel
import com.glacierpower.tennisapp.utils.ResultState

interface LiveEventsRepository {

    suspend fun getLiveEvent():ResultState<List<EventModel>>

    suspend fun getTournamentImage(id:Int)

    suspend fun getCountryFlag(code:String)
}