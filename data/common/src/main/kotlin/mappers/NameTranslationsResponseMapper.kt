package mappers

import api.responce.common.newCommon.NameTranslationsRs
import model.common.NameTranslationsModel

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
