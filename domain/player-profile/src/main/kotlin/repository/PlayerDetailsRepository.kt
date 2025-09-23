package repository

import models.player_details.details.PlayerDetailsModel
import models.player_details.events.PlayerEventsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface PlayerDetailsRepository {
    suspend fun getPlayerProfile(id: String): TennisResult<PlayerDetailsModel, DataError.NetworkError>

    suspend fun getPlayerEvents(id: String): TennisResult<PlayerEventsModel, DataError.NetworkError>
}
