package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.player_details.PlayerDetailsResponse
import com.glacierpower.tennisapp.data.service.responce.player_details.PlayerTeamInfoDetails
import com.glacierpower.tennisapp.data.service.responce.player_details.PrizeCurrentRaw
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.player_details.PlayerTeamInfoDetailsModel
import com.glacierpower.tennisapp.model.player_details.PrizeCurrentRawModel

fun PlayerDetailsResponse.toEntity(): PlayerDetailsModel {
    return PlayerDetailsModel(
        category?.toEntity(),
        country?.toEntity(),
        disabled,
        fullName,
        gender,
        id,
        name,
        nameCode,
        national,
        playerTeamInfoDetails?.toEntity(),
        ranking,
        shortName,
        slug,
        sport?.toEntity(),
        teamColor?.toEntity(),
        tournament?.toEntity(),
        type,
        userCount

    )
}

fun PlayerTeamInfoDetails.toEntity(): PlayerTeamInfoDetailsModel {
    return PlayerTeamInfoDetailsModel(
        birthDateTimestamp,
        birthplace,
        currentRanking,
        height,
        id,
        plays,
        prizeCurrent,
        prizeCurrentRaw.toEntity(),
        prizeTotal,
        prizeTotalRaw.toEntity(),
        residence,
        turnedPro,
        weight
    )
}

fun PrizeCurrentRaw.toEntity(): PrizeCurrentRawModel {
    return PrizeCurrentRawModel(
        currency, value
    )
}