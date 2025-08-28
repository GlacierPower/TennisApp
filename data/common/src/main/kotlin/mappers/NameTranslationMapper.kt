package mappers

import api.responce.common.NameTranslation
import model.NameTranslationModel

fun NameTranslation.toNameTranslationModel(): NameTranslationModel {
    return NameTranslationModel(
        ru = ru
    )
}