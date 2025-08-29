package mappers

import api.responce.common.Sport
import model.SportModel

fun Sport.toSportModel(): SportModel {
    return SportModel(
        name = name,
        slug = slug,
        id = id
    )
}