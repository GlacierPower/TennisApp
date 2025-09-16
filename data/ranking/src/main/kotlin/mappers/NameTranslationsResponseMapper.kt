package mappers

import api.responce.ranking.NameTranslationsRs
import com.glacierpower.tennisapp.domain.ranking.model.NameTranslationsModel

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
