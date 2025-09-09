package com.glacirepower.tennisapp.match_details.service

import model.player_summaries.SummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface EventService {
    suspend fun getEventDetails(eventId: String): TennisResult<SummariesModel, DataError.NetworkError>
}
