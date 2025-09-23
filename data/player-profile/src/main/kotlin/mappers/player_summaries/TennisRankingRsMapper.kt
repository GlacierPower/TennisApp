package mappers.player_summaries

import api.responce.player_details.TennisRankingRs
import models.player_details.details.TennisRankingModel

fun TennisRankingRs.toTennisRankingModel(): TennisRankingModel {
    return TennisRankingModel(
        id = id,
        type = type,
        points = points,
        ranking = ranking,
        tournaments = tournaments,
        officialUpdatedAt = officialUpdatedAt
    )
}
