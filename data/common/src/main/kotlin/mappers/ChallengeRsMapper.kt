package mappers

import api.responce.common.ChallengeRs
import kotlinx.serialization.InternalSerializationApi
import model.events.ChallengeModel

@OptIn(InternalSerializationApi::class)
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
