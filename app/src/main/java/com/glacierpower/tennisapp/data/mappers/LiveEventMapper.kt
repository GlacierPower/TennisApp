
package com.glacierpower.tennisapp.data.mappers

import api.responce.common.Team
import com.glacierpower.tennisapp.data.service.responce.live_event.*
import com.glacierpower.tennisapp.model.eventModel.*
import mappers.toCountryModel
import mappers.toFieldTranslationModel
import mappers.toSportModel
import mappers.toTeamColorModel
import mappers.toTeamModel
import model.CountryModel
import model.TeamModel

fun LiveEventList.toEntity(): EventModel {
    return EventModel(
        awayScore.toEntity(),
        awayTeam.toTeamModel(),
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
        roundInfo?.toEntity(),
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
        current,
        display,
        normaltime,
        period1,
        period1TieBreak,
        period2,
        period2TieBreak,
        period3,
        period3TieBreak,
        period4,
        period4TieBreak,
        period5,
        period5TieBreak,
        point
    )
}

fun Team.toEntity(): TeamModel {
    return TeamModel(
        name = name,
        slug = slug,
        shortName = shortName,
        gender = gender,
        sport = sport.toSportModel(),
        userCount = userCount,
        nameCode = nameCode,
        ranking = ranking,
        disabled = disabled,
        national = national,
        type = type,
        id = id,
        country = country.toCountryModel(),
        teamColor = teamColor.toTeamColorModel(),
        fieldTranslationsModel = fieldTranslations.toFieldTranslationModel()
    )
}

fun SubTeam.toEntity(): SubTeamModel {
    return SubTeamModel(
        CountryModel(
            alpha2 = this.country.alpha2,
            alpha3 = "",
            name = this.country.name,
            slug = ""
        ),
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
