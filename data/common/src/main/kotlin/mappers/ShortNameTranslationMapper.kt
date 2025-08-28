package mappers

import api.responce.common.ShortNameTranslation
import model.ShortNameTranslationModel

fun ShortNameTranslation.toShortNameTranslationModel(): ShortNameTranslationModel {
    return ShortNameTranslationModel(
        ar = ar,
        hi = hi,
        bn = bn
    )
}