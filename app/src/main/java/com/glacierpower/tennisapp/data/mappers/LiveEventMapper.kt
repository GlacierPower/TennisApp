package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.Events.*
import com.glacierpower.tennisapp.model.eventModel.*

fun LiveEventList.toEntity(): EventModel {
    return EventModel(
        awayScore.toEntity(),
        awayTeam.toEntity(),
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
        lastPeriod,
        periods.toEntity(),
        roundInfo.toEntity(),
        slug,
        startTimestamp,
        status,
        time.toEntity(),
        tournament.toEntity()
    )
}

fun Time.toEntity(): TimeModel {
    return TimeModel(
        currentPeriodStartTimestamp, period1, period2, period3, period4, period5
    )
}

fun Score.toEntity(): ScoreModel {
    return ScoreModel(
        current, display, period1, period2, period3, period4, period5, point
    )
}

fun Team.toEntity(): TeamModelLiveEvent {
    return TeamModelLiveEvent(
        country?.toEntity(),
        disabled,
        gender,
        id,
        name,
        nameCode,
        national,
        playerTeamInfo?.toEntity(),
        ranking,
        shortName,
        slug,
        sport.toEntity(),
        subTeam?.map {
                    it.toEntity()
        },
        teamColors.toEntity(),
        type,
        userCount
    )
}

fun SubTeam.toEntity(): SubTeamModel {
    return SubTeamModel(
        country.toEntity(),
        gender,
        id,
        name,
        nameCode,
        national,
        ranking,
        shortName,
        slug,
        sport,
        subTeam,
        teamColor,
        type,
        userCount
    )
}

fun Category.toEntity(): CategoryModel {
    return CategoryModel(
        flag, id, name, slug, sport
    )
}

fun PlayerTeamInfo.toEntity(): PlayerTeamInfoModel {
    return PlayerTeamInfoModel(
        id
    )
}

fun Changes.toEntity(): ChangesModel {
    return ChangesModel(
        changeTimestamp, changes
    )
}

fun Periods.toEntity(): PeriodsModel {
    return PeriodsModel(
        current, period1, period2, period3, period4, period5, point
    )
}

fun RoundInfo.toEntity(): RoundInfoModel {
    return RoundInfoModel(
        cupRoundType, name, round, slug
    )
}

fun Tournament.toEntity(): TournamentModel {
    return TournamentModel(
        category?.toEntity(), id, name, priority, slug, uniqueTournament.toEntity()
    )
}


fun UniqueTournament.toEntity(): UniqueTournamentModel {
    return UniqueTournamentModel(
        category.toEntity(),
        country,
        crowdsourcingEnabled,
        displayInverseHomeAwayTeams,
        groundType,
        hasEventPlayerStatistics,
        hasPerformanceGraphFeature,
        id,
        name,
        primaryColorHex,
        secondaryColorHex,
        slug,
        tennisPoints,
        userCount
    )
}
