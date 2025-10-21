package mappers

import api.responce.common.SportRs
import kotlinx.serialization.InternalSerializationApi
import model.common.SportModel
@InternalSerializationApi
fun SportRs.toSportModel(): SportModel {
    return SportModel(
        id = id,
        slug = slug,
        name = name,
        nameTranslations = nameTranslations?.toNameTranslationsModel()
    )
}
