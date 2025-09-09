package api.api

import api.responce.images.PLayerManifestResponse
import model.ApiResult
import retrofit2.http.GET

interface ImagesApi {

    @GET("tennis-images-t3/reuters/headshots/players/2025/manifest.json")
    suspend fun getPlayerManifest(): ApiResult<PLayerManifestResponse>

    @GET("/flags-images-t3/sr/country-flags/flags/manifest")
    suspend fun getCountryFlagsManifest(): ApiResult<PLayerManifestResponse>
}
