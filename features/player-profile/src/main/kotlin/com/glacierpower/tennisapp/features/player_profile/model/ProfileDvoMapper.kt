package com.glacierpower.tennisapp.features.player_profile.model

import models.player_details.events.PlayerEventsDataModel
import utils.orZero
import utils.toDayMonth

const val HOME_TEAM_WIN = 1
const val AWAY_TEAM_WIN = 2
fun PlayerEventsDataModel.toSummariesDvo(playerId: String): PlayerEventDvo {
    val isHomePlayer = playerId == homeTeam.id.toString()
    val isAwayPlayer = playerId == awayTeam.id.toString()

    val isWin = when {
        isHomePlayer && winnerCode == 1 -> true
        isAwayPlayer && winnerCode == 2 -> true
        isHomePlayer && winnerCode == 2 -> false
        isAwayPlayer && winnerCode == 1 -> false
        else -> false
    }
    return PlayerEventDvo(
        date = startAt.toDayMonth().orEmpty(),
        homeName = homeTeam.name,
        awayName = awayTeam.name,
        matchStatus = MatchStatus.fromString(statusMore.orEmpty()),
        homeScore = homeScore?.display.orZero().toString(),
        awayScore = awayScore?.display.orZero().toString(),
        tournamentName = league.name,
        groundType = groundType.orEmpty(),
        isWin = isWin,
        rankName = "ATP: ",
        isHomeWin = winnerCode == HOME_TEAM_WIN,
        isAwayWin = winnerCode == AWAY_TEAM_WIN,
        eventId = leagueId.toString(),
        tournamentLogo = league.logo,
        mainStatModel = mainStat,
    )
}
