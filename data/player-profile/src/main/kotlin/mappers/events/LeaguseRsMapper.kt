package mappers.events

import api.responce.player_events.LeagueRs
import mappers.toNameTranslationsModel
import models.player_details.events.LeagueModel

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
