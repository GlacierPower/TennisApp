package mappers.player_summaries

import api.responce.player_summaries.PlayerSummariesResponse
import models.player_summaries.PlayerSummariesModel

fun PlayerSummariesResponse.toPlayerSummariesModel(): PlayerSummariesModel {
    return PlayerSummariesModel(
        generatedAt = generatedAt,
        summaries = summaries
            .toListSummariesModel()
            .sortedByDescending { model ->
                val parts = model.sportEvent.startTime.split(".")
                parts[1].toInt() * 100 + parts[0].toInt()
            }
    )
}
