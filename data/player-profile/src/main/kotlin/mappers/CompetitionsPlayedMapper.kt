package mappers

import api.responce.player_profile.CompetitionsPlayed
import models.CompetitionsPlayedModel

fun List<CompetitionsPlayed>.toCompetitionsPlayedModel(): List<CompetitionsPlayedModel> {
    return this.map { competitionsPlayed ->
        CompetitionsPlayedModel(
            id = competitionsPlayed.id,
            name = competitionsPlayed.name,
            type = competitionsPlayed.type,
            gender = competitionsPlayed.gender
        )
    }
}
