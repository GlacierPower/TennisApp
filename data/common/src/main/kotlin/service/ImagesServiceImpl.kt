package service

import api.api.ImagesApi
import mappers.images.toPlayerManifestModel
import model.images.PlayerManifestModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class ImagesServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val imagesApi: ImagesApi
) : ImagesService {

    override suspend fun getPlayerImagesManifest(): TennisResult<PlayerManifestModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                imagesApi.getPlayerManifest()
            },
            mapper = { playerManifest ->
                playerManifest.toPlayerManifestModel()
            }
        )
    }

    override suspend fun getCountryFlagsManifest(): TennisResult<PlayerManifestModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                imagesApi.getCountryFlagsManifest()
            },
            mapper = { playerManifest ->
                playerManifest.toPlayerManifestModel()
            }
        )
    }
}
