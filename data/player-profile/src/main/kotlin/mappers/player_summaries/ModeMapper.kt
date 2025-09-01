package mappers.player_summaries

import api.responce.player_summaries.Mode
import models.player_summaries.ModeModel

fun Mode.toModeModel(): ModeModel{
    return ModeModel(
        bestOf = bestOf
    )
}