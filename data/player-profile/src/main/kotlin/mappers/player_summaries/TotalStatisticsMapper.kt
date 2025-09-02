
package mappers.player_summaries

import api.responce.player_summaries.TotalStatistics
import models.player_summaries.TotalStatisticsModel

fun TotalStatistics.toTotalStatisticsModel(): TotalStatisticsModel {
    return TotalStatisticsModel(
        aces = aces,
        backhandErrors = backhandErrors,
        backhandUnforcedErrors = backhandUnforcedErrors,
        backhandWinners = backhandWinners,
        breakpointsWon = breakpointsWon,
        doubleFaults = doubleFaults,
        dropShotUnforcedErrors = dropShotUnforcedErrors,
        dropShotWinners = dropShotWinners,
        firstServePointsWon = firstServePointsWon,
        firstServeSuccessful = firstServeSuccessful,
        forehandErrors = forehandErrors,
        forehandUnforcedErrors = forehandUnforcedErrors,
        forehandWinners = forehandWinners,
        gamesWon = gamesWon,
        groundstrokeErrors = groundstrokeErrors,
        groundstrokeUnforcedErrors = groundstrokeUnforcedErrors,
        groundstrokeWinners = groundstrokeWinners,
        lobUnforcedErrors = lobUnforcedErrors,
        lobWinners = lobWinners,
        maxGamesInArow = maxGamesInArow,
        maxPointsInArow = maxPointsInArow,
        overheadStrokeErrors = overheadStrokeErrors,
        overheadStrokeUnforcedErrors = overheadStrokeUnforcedErrors,
        overheadStrokeWinners = overheadStrokeWinners,
        pointsWon = pointsWon,
        pointsWonFromLast10 = pointsWonFromLast10,
        returnErrors = returnErrors,
        returnWinners = returnWinners,
        secondServePointsWon = secondServePointsWon,
        secondServeSuccessful = secondServeSuccessful,
        serviceGamesWon = serviceGamesWon,
        servicePointsLost = servicePointsLost,
        servicePointsWon = servicePointsWon,
        tiebreaksWon = tiebreaksWon,
        totalBreakpoints = totalBreakpoints,
        volleyUnforcedErrors = volleyUnforcedErrors,
        volleyWinners = volleyWinners
    )
}
