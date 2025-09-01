package mappers

import api.responce.player_profile.Statistics
import models.StatisticsModel

fun Statistics.toStatisticsModel(): StatisticsModel {
    return StatisticsModel(
        competitionsPlayed = competitionsPlayed,
        competitionsWon = competitionsWon,
        matchesPlayed = matchesPlayed,
        matchesWon = matchesWon
    )
}
