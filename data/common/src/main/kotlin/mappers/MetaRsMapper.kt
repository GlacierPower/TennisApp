package mappers

import api.responce.common.Meta
import model.events.MetaModel

fun Meta.toMetaModel(): MetaModel {
    return MetaModel(
        currentPage = currentPage,
        from = from,
        lastPage = lastPage,
        perPage = perPage,
        to = to,
        total = total
    )
}
