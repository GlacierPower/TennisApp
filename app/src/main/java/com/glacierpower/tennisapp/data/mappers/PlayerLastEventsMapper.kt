package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.Events
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel

fun Events.toEntity(): LastEventModel {
    return LastEventModel(
        awayScore.toEntity(),
        awayTeam.toEntity(),
        awayTeamSeed,
        changes.toEntity(),
        crowdsourcingDataDisplayEnabled,
        customId,
        finalResultOnly,
        firstToServe,
        groundType,
        hasGlobalHighlights,
        homeScore.toEntity(),
        homeTeam.toEntity(),
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