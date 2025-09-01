package mappers.player_summaries

import api.responce.player_summaries.SportEventStatus
import models.player_summaries.SportEventStatusModel

fun SportEventStatus.toSportEventStatusModel(): SportEventStatusModel{
    return SportEventStatusModel(
        status = status,
        matchStatus = matchStatus,
        homeScore = homeScore,
        awayScore = awayScore,
        periodScores = periodScores.toPeriodScoresModel(),
        winnerId = winnerId
    )
}