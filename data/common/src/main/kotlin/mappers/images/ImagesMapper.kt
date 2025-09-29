package mappers.images

import api.responce.images.PLayerManifestResponse
import model.images.PlayerManifestModel

fun PLayerManifestResponse.toPlayerManifestModel(): PlayerManifestModel {
    return PlayerManifestModel(
        provider = provider,
        league = league,
        type = type,
        manifestDate = manifestDate,
        trial = trial,
        assetList = assetList.toAssetsModel()
    )
}
