package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.*
import com.glacierpower.tennisapp.model.*

fun Rankings.toEntity(): RankingModel {
    return RankingModel(
        bestRanking,
        bestRankingDateTimestamp,
        country,
        id,
        points,
        previousPoints,
        previousRanking,
        ranking,
        rankingClass,
        rowName,
        team.toEntity(),
        tournamentsPlayed,
        type
    )
}

fun Team.toEntity(): TeamModel {
    return TeamModel(
        country.toEntity(),
        disabled,
        gender,
        id,
        name,
        nameCode,
        national,
        ranking,
        shortName,
        slug,
        sport.toEntity(),
        teamColors.toEntity(),
        type,
        userCount
    )
}

fun Country.toEntity(): CountryModel {
    return CountryModel(
        alpha2,
        name
    )
}

fun Sport.toEntity(): SportModel {
    return SportModel(
        id,
        name,
        slug
    )
}

fun TeamColor.toEntity(): ColorModel {
    return ColorModel(
        primary,
        secondary,
        text
    )
}