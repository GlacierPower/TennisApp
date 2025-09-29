package mappers.events

import api.responce.ranking.TeamRs
import mappers.toNameTranslationsModel
import model.events.TeamModel

fun TeamRs.toTeamModel(): TeamModel {
    return TeamModel(
        id = id,
        sportId = sportId,
        categoryId = categoryId,
        venueId = venueId,
        managerId = managerId,
        slug = slug,
        name = name,
        hasLogo = hasLogo,
        logo = logo,
        nameTranslationsRs = nameTranslationsRs.toNameTranslationsModel(),
        nameShort = nameShort,
        nameFull = nameFull,
        nameCode = nameCode,
        hasSub = hasSub,
        gender = gender,
        isNationality = isNationality,
        countryCode = countryCode,
        country = country,
        flag = flag,
        foundation = foundation
    )
}
