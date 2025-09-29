package mappers

import api.responce.common.newCommon.SectionRs
import kotlinx.serialization.InternalSerializationApi
import model.common.SectionModel
@InternalSerializationApi
fun SectionRs.toSectionModel(): SectionModel {
    return SectionModel(
        id = id,
        sportId = sportId,
        slug = slug,
        name = name,
        nameTranslations = nameTranslations?.toNameTranslationsModel(),
        priority = priority,
        flag = flag
    )
}
