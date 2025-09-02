
package mappers.player_summaries

import api.responce.player_summaries.Competition
import models.player_summaries.CompetitionModel

fun Competition.toCompetitionModel(): CompetitionModel {
    return CompetitionModel(
        id = id,
        name = name,
        parentId = parentId,
        type = type,
        gender = gender,
        level = level
    )
}
