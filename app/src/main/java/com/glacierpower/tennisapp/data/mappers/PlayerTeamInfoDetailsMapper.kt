
package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.player_details.PlayerTeamInfoDetails
import com.glacierpower.tennisapp.model.player_details.PlayerTeamInfoDetailsModel

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
