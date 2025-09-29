package model.images

data class PlayerManifestModel(
    val provider: String,
    val league: String,
    val type: String,
    val manifestDate: String,
    val trial: Boolean? = false,
    val assetList: List<AssetsModel>
)
