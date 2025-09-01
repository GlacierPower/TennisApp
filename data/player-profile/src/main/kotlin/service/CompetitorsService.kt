package service

import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface CompetitorsService {

    suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError>
}