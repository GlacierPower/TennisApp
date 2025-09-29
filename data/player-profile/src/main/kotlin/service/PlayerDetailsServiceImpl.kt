package service

import api.api.RankingApi
import mappers.events.toPlayerEventsModel
import mappers.player_summaries.toPlayerDetailsModel
import models.player_details.details.PlayerDetailsModel
import model.events.PlayerEventsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class PlayerDetailsServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val rankingApi: RankingApi
) : PlayerDetailsService {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerDetailsModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend { rankingApi.getPlayerDetails(id) },
            mapper = { details ->
                details.data.toPlayerDetailsModel()
            }
        )
    }

    override suspend fun getPlayerEvents(id: String): TennisResult<PlayerEventsModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend { rankingApi.getPlayerEvents(id) },
            mapper = { events ->
                events.toPlayerEventsModel()
            }
        )
    }
}
