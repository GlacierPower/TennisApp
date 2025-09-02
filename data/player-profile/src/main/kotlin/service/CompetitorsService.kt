
package service

import models.PlayerProfileModel
import models.player_summaries.PlayerSummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface CompetitorsService {

    suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError>

    suspend fun getPlayerSummaries(id: String): TennisResult<PlayerSummariesModel, DataError.NetworkError>
}
