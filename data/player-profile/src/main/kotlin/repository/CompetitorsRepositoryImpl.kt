package repository

import model.player_summaries.PlayerSummariesModel
import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import service.CompetitorsService
import service.ImagesService
import javax.inject.Inject

class CompetitorsRepositoryImpl @Inject constructor(
    private val competitorsService: CompetitorsService,
    private val imageService: ImagesService
) : CompetitorsRepository, ImagesRepository {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError> =
        competitorsService.getPlayerProfile(id)

    override suspend fun getPlayerSummaries(id: String): TennisResult<PlayerSummariesModel, DataError.NetworkError> =
        competitorsService.getPlayerSummaries(id)

    override suspend fun getPlayerManifest(): Map<String?, String> {
        val assets = imageService.getPlayerImagesManifest().getOrNull()?.assetList ?: emptyList()
        return assets.associate { asset ->
            asset.playerId to ""
        }
    }
}
