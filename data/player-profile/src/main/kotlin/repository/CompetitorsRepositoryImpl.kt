package repository

import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import service.CompetitorsService
import javax.inject.Inject

class CompetitorsRepositoryImpl @Inject constructor(
    private val competitorsService: CompetitorsService
) : CompetitorsRepository {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError> =
        competitorsService.getPlayerProfile(id)
}