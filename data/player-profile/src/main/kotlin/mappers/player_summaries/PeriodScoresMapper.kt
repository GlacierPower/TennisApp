package mappers.player_summaries

import api.responce.player_summaries.PeriodScores
import models.player_summaries.PeriodScoresModel

fun List<PeriodScores>.toPeriodScoresModel(): List<PeriodScoresModel> {
    return this.map { period ->
        PeriodScoresModel(
            homeScore = period.homeScore,
            awayScore = period.awayScore,
            type = period.type,
            number = period.number
        )
    }
}