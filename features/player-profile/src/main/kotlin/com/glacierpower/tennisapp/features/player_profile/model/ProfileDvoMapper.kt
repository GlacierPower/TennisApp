package com.glacierpower.tennisapp.features.player_profile.model

import models.player_summaries.SummariesModel
import utils.orZero

fun SummariesModel.toSummariesDvo(playerId: String?): SummariesDvo {
    return SummariesDvo(
        date = sportEvent.startTime,
        homeName = sportEvent.competitors.first().name,
        awayName = sportEvent.competitors.last().name,
        matchStatus = MatchStatus.valueOf(sportEventStatus.matchStatus.orEmpty().uppercase()),
        homeScore = sportEventStatus.homeScore.orZero(),
        awayScore = sportEventStatus.awayScore.orZero(),
        tournamentName = sportEvent.sportEventContext.competition.name,
        tournamentCountry = sportEvent.venue.countryName,
        isWin = sportEventStatus.winnerId == playerId,
        rankName = sportEvent.sportEventContext.category.name,
        isHomeWin = sportEventStatus.homeScore.orZero() > sportEventStatus.awayScore.orZero(),
        isAwayWin = sportEventStatus.homeScore.orZero() < sportEventStatus.awayScore.orZero()
    )
}
