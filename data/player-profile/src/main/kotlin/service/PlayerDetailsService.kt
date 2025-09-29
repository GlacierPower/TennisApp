package service

import models.player_details.details.PlayerDetailsModel
import model.events.PlayerEventsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface PlayerDetailsService {

    suspend fun getPlayerProfile(id: String): TennisResult<PlayerDetailsModel, DataError.NetworkError>

    suspend fun getPlayerEvents(id: String): TennisResult<PlayerEventsModel, DataError.NetworkError>
}
