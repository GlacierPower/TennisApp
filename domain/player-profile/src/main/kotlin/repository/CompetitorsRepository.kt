package repository

import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface CompetitorsRepository {
    suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError>
}