
package mappers

import api.responce.player_profile.PlayerInfo
import models.PlayerInfoModel
import utils.dateToAge
import utils.formatDateToDotted

fun PlayerInfo.toPlayerInfoModel(): PlayerInfoModel {
    return PlayerInfoModel(
        proYear = proYear,
        handedness = handedness,
        highestSinglesRanking = highestSinglesRanking,
        highestDoublesRanking = highestDoublesRanking,
        weight = weight,
        height = height,
        dateOfBirth = dateOfBirth.formatDateToDotted(),
        age = dateOfBirth.dateToAge(),
        highestSinglesRankingDate = highestSinglesRankingDate,
        highestDoublesRankingDate = highestDoublesRankingDate
    )
}
