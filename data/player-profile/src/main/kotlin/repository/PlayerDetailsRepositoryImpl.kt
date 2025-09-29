package repository

import models.player_details.details.PlayerDetailsModel
import model.events.PlayerEventsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import service.PlayerDetailsService
import javax.inject.Inject

class PlayerDetailsRepositoryImpl @Inject constructor(
    private val playerDetailsService: PlayerDetailsService
) : PlayerDetailsRepository {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerDetailsModel, DataError.NetworkError> =
        playerDetailsService.getPlayerProfile(id)

    override suspend fun getPlayerEvents(id: String): TennisResult<PlayerEventsModel, DataError.NetworkError> =
        playerDetailsService.getPlayerEvents(id)
}
