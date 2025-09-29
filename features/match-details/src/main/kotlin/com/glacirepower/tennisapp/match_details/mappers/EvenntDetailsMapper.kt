package com.glacirepower.tennisapp.match_details.mappers

import com.glacirepower.tennisapp.match_details.model.TotalScoreDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.PlayerEventsDataModel
import utils.orEmptyString
import utils.toHoursMinutes

@OptIn(InternalSerializationApi::class)
internal fun PlayerEventsDataModel.toScoreDvo(): TotalScoreDvo {
    val matchTime = listOf(
        timeDetails?.period1,
        timeDetails?.period2,
        timeDetails?.period3,
        timeDetails?.period4,
        timeDetails?.period5
    ).sumOf { it ?: 0 }
    return TotalScoreDvo(
        homeTeamName = homeTeam.nameShort,
        awayTeamName = awayTeam.nameShort,
        setHome = homeScore?.display.orEmptyString(),
        setAway = awayScore?.display.orEmptyString(),
        firstSetHome = homeScore?.period1.orEmptyString(),
        secondSetHome = homeScore?.period2.orEmptyString(),
        thirdSetHome = homeScore?.period3.orEmptyString(),
        fourthSetHome = homeScore?.period4.orEmptyString(),
        fifthSetHome = homeScore?.period5.orEmptyString(),
        firstSetAway = awayScore?.period1.orEmptyString(),
        secondSetAway = awayScore?.period2.orEmptyString(),
        thirdSetAway = awayScore?.period3.orEmptyString(),
        fourthSetAway = awayScore?.period4.orEmptyString(),
        fifthSetAway = awayScore?.period5.orEmptyString(),
        matchTime = matchTime.toHoursMinutes(),
        firstSetTime = timeDetails?.period1.toHoursMinutes(),
        secondSetTime = timeDetails?.period2.toHoursMinutes(),
        thirdSetTime = timeDetails?.period3.toHoursMinutes(),
        fourthSetTime = timeDetails?.period4.toHoursMinutes(),
        fifthSetTime = timeDetails?.period5.toHoursMinutes(),
        firstSetTieHomeBreak = homeScore?.period1TieBreak.orEmptyString(),
        firstSetTieAwayBreak = awayScore?.period1TieBreak.orEmptyString(),
        secondSetTieHomeBreak = homeScore?.period2TieBreak.orEmptyString(),
        secondSetTieAwayBreak = awayScore?.period2TieBreak.orEmptyString(),
        thirdSetTieHomeBreak = homeScore?.period3TieBreak.orEmptyString(),
        thirdSetTieAwayBreak = awayScore?.period3TieBreak.orEmptyString(),
        fourthSetTieHomeBreak = homeScore?.period4TieBreak.orEmptyString(),
        fourthSetTieAwayBreak = awayScore?.period4TieBreak.orEmptyString(),
        fifthSetTieHomeBreak = homeScore?.period5TieBreak.orEmptyString(),
        fifthSetTieAwayBreak = awayScore?.period5TieBreak.orEmptyString()
    )
}
