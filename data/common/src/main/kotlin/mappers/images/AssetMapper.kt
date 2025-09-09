package mappers.images

import api.responce.images.Assets
import model.images.AssetsModel

fun List<Assets>.toAssetsModel(): List<AssetsModel> {
    return this.map { asset ->
        AssetsModel(
            id = asset.id,
            created = asset.created,
            updated = asset.updated,
            title = asset.title,
            description = asset.description,
            playerId = asset.playerId,
            copyright = asset.copyright,
            posed = asset.posed,
            links = asset.links.toLinksModel(),
            refs = asset.refs.toRefsModel(),
            provider = asset.provider.toProviderModel()
        )
    }
}
