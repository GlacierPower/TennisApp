
package mappers.player_summaries

import api.responce.player_summaries.Season
import model.player_summaries.SeasonModel

fun Season.toSeasonModel(): SeasonModel {
    return SeasonModel(
        id = id,
        name = name,
        startDate = startDate,
        endDate = endDate,
        year = year,
        competitionId = competitionId
    )
}
