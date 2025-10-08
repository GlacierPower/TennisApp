package com.glacirepower.tennisapp.match_details.mappers

import com.glacirepower.tennisapp.match_details.model.EventDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import utils.orEmptyString
import utils.orZero
import utils.toDotDate

@OptIn(InternalSerializationApi::class)
fun PlayerEventsDataModel.toEventDvo(): EventDvo {
    return EventDvo(
        leagueName = league.name,
        homeTeamName = homeTeam.nameShort,
        awayTeamName = awayTeam.nameShort,
        homeTeamScore = homeScore?.display.orEmptyString(),
        awayTeamScore = awayScore?.display.orEmptyString(),
        date = startAt.toDotDate().orEmpty(),
        matchStatus = status,
        isWinner = winnerCode == 1,
        homeTeamImage = homeTeam.logo,
        awayTeamImage = awayTeam.logo,
        homeTeamCountry = homeTeam.countryCode,
        awayTeamCountry = awayTeam.countryCode,
        isHomeWin = winnerCode == 1,
        isAwayWin = winnerCode == 2,
        homeOdds = mainOdds?.outcome1?.value.orZero(),
        awayOdds = mainOdds?.outcome2?.value.orZero(),
        mainStatsDvo = mainStat?.toMainStatsDvo(),
        homeTeamId = homeTeamId.toString(),
        awayTeamId = awayTeamId.toString(),
        leagueId = leagueId.toString()
    )
}
