package service

import model.player_summaries.PlayerSummariesModel
import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface CompetitorsService {

    suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError>

    suspend fun getPlayerSummaries(id: String): TennisResult<PlayerSummariesModel, DataError.NetworkError>
}
