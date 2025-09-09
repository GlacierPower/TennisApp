package mappers.images

import api.responce.images.Links
import model.images.LinksModel

fun List<Links>.toLinksModel(): List<LinksModel> {
    return this.map { link ->
        LinksModel(
            width = link.width,
            height = link.height,
            href = link.href
        )
    }
}
