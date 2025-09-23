package mappers

import api.responce.common.newCommon.SportRs
import model.common.SportModel

fun SportRs.toSportModel(): SportModel {
    return SportModel(
        id = id,
        slug = slug,
        name = name,
        nameTranslations = nameTranslations?.toNameTranslationsModel()
    )
}
