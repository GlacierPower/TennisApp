package mappers

import api.responce.common.LeagueRs
import kotlinx.serialization.InternalSerializationApi
import model.events.LeagueModel

@OptIn(InternalSerializationApi::class)
fun LeagueRs.toLeagueModel(): LeagueModel {
    return LeagueModel(
        id = id,
        sportId = sportId,
        sectionId = sectionId,
        slug = slug,
        name = name,
        nameTranslationsRs = nameTranslationsRs.toNameTranslationsModel(),
        hasLogo = hasLogo,
        logo = logo
    )
}
