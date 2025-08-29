package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.Events
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import mappers.toTeamModel

fun Events.toEntity(): LastEventModel {
    return LastEventModel(
        awayScore.toEntity(),
        awayTeam.toTeamModel(),
        awayTeamSeed,
        changes.toEntity(),
        crowdsourcingDataDisplayEnabled,
        customId,
        finalResultOnly,
        firstToServe,
        groundType,
        hasGlobalHighlights,
        homeScore.toEntity(),
        homeTeam.toTeamModel(),
        homeTeamSeed,
        id,
        periods.toEntity(),
        roundInfo?.toEntity(),
        slug,
        startTimestamp,
        status,
        time.toEntity(),
        tournament.toEntity(),
        winnerCode
    )
}
