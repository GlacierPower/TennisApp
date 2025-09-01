package mappers.player_summaries

import api.responce.player_summaries.PlayerSummariesResponse
import models.player_summaries.PlayerSummariesModel

fun PlayerSummariesResponse.toPlayerSummariesModel(): PlayerSummariesModel {
return PlayerSummariesModel(
    generatedAt = generatedAt,
    summaries = summaries.toListSummariesModel()
)
}