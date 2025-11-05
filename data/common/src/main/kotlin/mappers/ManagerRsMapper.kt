package mappers

import api.responce.common.ManagerRs
import model.common.ManagerModel

fun ManagerRs.toManagerModel(): ManagerModel {
    return ManagerModel(
        id = id,
        slug = slug,
        name = name,
        nameTranslations = nameTranslations,
        nameShort = nameShort,
        hasPhoto = hasPhoto,
        photo = photo,
        dateBirth = dateBirth,
        nationalityCode = nationalityCode,
        performance = performance.toPerformanceModel(),
        preferredFormation = preferredFormation
    )
}
