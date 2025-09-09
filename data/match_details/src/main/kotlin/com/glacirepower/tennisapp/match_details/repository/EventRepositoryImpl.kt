package com.glacirepower.tennisapp.match_details.repository

import com.glacirepower.tennisapp.match_details.service.EventService
import model.player_summaries.SummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventService: EventService
) : EventRepository {
    override suspend fun getEventDetails(eventId: String): TennisResult<SummariesModel, DataError.NetworkError> =
        eventService.getEventDetails(eventId)
}
