
package mappers

import api.responce.player_profile.PlayerInfo
import models.PlayerInfoModel

fun PlayerInfo.toPlayerInfoModel(): PlayerInfoModel {
    return PlayerInfoModel(
        proYear = proYear,
        handedness = handedness,
        highestSinglesRanking = highestSinglesRanking,
        highestDoublesRanking = highestDoublesRanking,
        weight = weight,
        height = height,
        dateOfBirth = dateOfBirth,
        highestSinglesRankingDate = highestSinglesRankingDate,
        highestDoublesRankingDate = highestDoublesRankingDate
    )
}
