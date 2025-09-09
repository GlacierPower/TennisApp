package api.responce.images

import com.squareup.moshi.Json

data class PLayerManifestResponse(
    val provider: String,
    val league: String,
    val type: String,
    @property:Json("manifest_date")
    val manifestDate: String,
    val trial: Boolean? = false,
    @property:Json("assetlist")
    val assetList: List<Assets>
)
