package mappers

import api.responce.common.NameTranslationsRs
import kotlinx.serialization.InternalSerializationApi
import model.common.NameTranslationsModel
@InternalSerializationApi
fun NameTranslationsRs.toNameTranslationsModel(): NameTranslationsModel {
    return NameTranslationsModel(
        en = en,
        ru = ru,
        es = es,
        fr = fr,
        zh = zh,
        pt = pt,
        el = el,
        it = it
    )
}
