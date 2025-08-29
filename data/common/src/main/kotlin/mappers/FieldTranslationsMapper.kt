package mappers

import api.responce.common.FieldTranslations
import model.FieldTranslationsModel

fun FieldTranslations.toFieldTranslationModel(): FieldTranslationsModel {
    return FieldTranslationsModel(
        nameTranslationModel = nameTranslation.toNameTranslationModel(),
        shortNameTranslationModel = shortNameTranslation.toShortNameTranslationModel()
    )
}