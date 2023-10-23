package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.player_near_events.NextEvent
import com.glacierpower.tennisapp.data.service.responce.player_near_events.PlayerNearEventsResponse
import com.glacierpower.tennisapp.data.service.responce.player_near_events.PreviousEvent
import com.glacierpower.tennisapp.model.player_details.NextEventModel
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.model.player_details.PreviousEventModel

fun PlayerNearEventsResponse.toEntity(): PlayerNearEventsModel {
    return PlayerNearEventsModel(
        nextEvent?.toEntity(),
        previousEvent!!.toEntity()
    )
}

fun NextEvent.toEntity(): NextEventModel {
    return NextEventModel(
        awayScore?.toEntity(),
        awayTeam.toEntity(),
        changes.toEntity(),
        crowdsourcingDataDisplayEnabled,
        customId,
        finalResultOnly,
        groundType,
        hasGlobalHighlights,
        homeScore?.toEntity(),
        homeTeam.toEntity(),
        homeTeamSeed,
        id,
        periods.toEntity(),
        roundInfo.toEntity(),
        slug,
        startTimestamp,
        status,
        time?.toEntity(),
        tournament.toEntity()


    )
}

fun PreviousEvent.toEntity(): PreviousEventModel {
    return PreviousEventModel(
        awayScore.toEntity(),
        awayTeam.toEntity(),
        awayTeamSeed,
        changes.toEntity(),
        crowdsourcingDataDisplayEnabled,
        customId,
        endTimestamp,
        finalResultOnly,
        firstToServe,
        groundType,
        hasGlobalHighlights,
        homeScore.toEntity(),
        homeTeam.toEntity(),
        id,
        periods.toEntity(),
        roundInfo.toEntity(),
        slug,
        startTimestamp,
        status,
        time.toEntity(),
        tournament.toEntity(),
        winnerCode
    )
}