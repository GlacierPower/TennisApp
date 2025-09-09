package service

import model.images.PlayerManifestModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface ImagesService {
    suspend fun getPlayerImagesManifest(): TennisResult<PlayerManifestModel, DataError.NetworkError>

    suspend fun getCountryFlagsManifest(): TennisResult<PlayerManifestModel, DataError.NetworkError>
}
