package mappers

import api.responce.player_profile.CompetitionsPlayed
import models.CompetitionsPlayedModel

fun CompetitionsPlayed.toCompetitionsPlayedModel(): CompetitionsPlayedModel {
    return CompetitionsPlayedModel(
        id = id,
        name = name,
        type = type,
        gender = gender
    )
}
