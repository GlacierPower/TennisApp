
package service

import api.api.CompetitorsApi
import mappers.player_summaries.toPlayerSummariesModel
import mappers.toPlayerProfileModel
import models.PlayerProfileModel
import models.player_summaries.PlayerSummariesModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class CompetitorsServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val competitorsApi: CompetitorsApi
) : CompetitorsService {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError> =
        networkHelper.fetchToTennisResult(
            apiCall = suspend { competitorsApi.getPlayerProfile(id) },
            mapper = { profileRs ->
                profileRs.toPlayerProfileModel()
            }
        )

    override suspend fun getPlayerSummaries(id: String): TennisResult<PlayerSummariesModel, DataError.NetworkError> =
        networkHelper.fetchToTennisResult(
            apiCall = suspend { competitorsApi.getPlayerSummaries(id) },
            mapper = { summaries ->
                summaries.toPlayerSummariesModel()
            }
        )
}
