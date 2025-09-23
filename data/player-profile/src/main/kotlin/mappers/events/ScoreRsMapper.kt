package mappers.events

import api.responce.player_events.ScoreRs
import models.player_details.events.ScoreModel

fun ScoreRs.toScoreModel(): ScoreModel {
    return ScoreModel(
        current = current,
        display = display,
        period1 = period1,
        period2 = period2,
        period3 = period3,
        period4 = period4,
        period5 = period5,
        normalTime = normalTime,
        point = point,
        period1TieBreak = period1TieBreak,
        period2TieBreak = period2TieBreak,
        period3TieBreak = period3TieBreak,
        period4TieBreak = period4TieBreak,
        period5TieBreak = period5TieBreak
    )
}
