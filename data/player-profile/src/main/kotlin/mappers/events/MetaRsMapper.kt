package mappers.events

import api.responce.ranking.Meta
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
