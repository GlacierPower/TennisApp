package com.glacirepower.tennisapp.match_details.repository

import model.player_summaries.SummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface EventRepository {
    suspend fun getEventDetails(eventId: String): TennisResult<SummariesModel, DataError.NetworkError>
}
