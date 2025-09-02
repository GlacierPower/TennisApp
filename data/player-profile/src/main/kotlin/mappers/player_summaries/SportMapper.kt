
package mappers.player_summaries

import api.responce.player_summaries.Sport
import models.player_summaries.SportModel

fun Sport.toSportModel(): SportModel {
    return SportModel(
        id = id,
        name = name
    )
}
