
package mappers.player_summaries

import api.responce.player_summaries.Stage
import model.player_summaries.StageModel

fun Stage.toStageModel(): StageModel {
    return StageModel(
        order = order,
        type = type,
        phase = phase,
        startDate = startDate,
        endDate = endDate,
        year = year
    )
}
