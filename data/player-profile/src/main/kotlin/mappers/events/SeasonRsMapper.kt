package mappers.events

import api.responce.player_events.SeasonRs
import models.player_details.events.SeasonModel

fun SeasonRs.toSeasonModel(): SeasonModel {
    return SeasonModel(
        id = id,
        leagueId = leagueId,
        slug = slug,
        name = name,
        yearStart = yearStart,
        yearEnd = yearEnd
    )
}
