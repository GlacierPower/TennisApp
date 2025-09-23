package mappers.events

import api.responce.player_events.ChallengeRs
import mappers.toNameTranslationsModel
import models.player_details.events.ChallengeModel

fun ChallengeRs.toChallengeModel(): ChallengeModel {
    return ChallengeModel(
        id = id,
        sportId = sportId,
        leagueId = leagueId,
        slug = slug,
        name = name,
        nameTranslationsRs = nameTranslationsRs.toNameTranslationsModel(),
        order = order,
        priority = priority
    )
}
