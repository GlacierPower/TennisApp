package mappers

import api.responce.common.PerformanceRs
import model.common.PerformanceModel

fun PerformanceRs.toPerformanceModel(): PerformanceModel {
    return PerformanceModel(
        total = total,
        wins = wins,
        draws = draws,
        losses = losses,
        goalsScored = goalsScored,
        goalsConceded = goalsConceded,
        totalPoints = totalPoints
    )
}
