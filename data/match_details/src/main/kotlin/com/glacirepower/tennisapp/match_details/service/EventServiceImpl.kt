package com.glacirepower.tennisapp.match_details.service

import api.api.EventApi
import mappers.player_summaries.toListSummariesModel
import model.player_summaries.SummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelperImpl
import javax.inject.Inject

class EventServiceImpl @Inject constructor(
    private val networkHelperImpl: NetworkHelperImpl,
    private val eventApi: EventApi
) : EventService {
    override suspend fun getEventDetails(eventId: String): TennisResult<SummariesModel, DataError.NetworkError> =
        networkHelperImpl.fetchToTennisResult(
            apiCall = suspend {
                eventApi.getEventDetails(eventId)
            },
            mapper = { event ->
                event.toListSummariesModel()
            }
        )
}
