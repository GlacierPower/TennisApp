
package mappers.player_summaries

import api.responce.player_summaries.SportEvent
import models.player_summaries.SportEventModel
import utils.convertToDayMonth

fun SportEvent.toSportEventModel(): SportEventModel {
    return SportEventModel(
        id = id,
        startTime = startTime.convertToDayMonth(),
        startTimeConfirmed = startTimeConfirmed,
        sportEventContext = sportEventContext.toSportEventContextModel(),
        coverage = coverage.toCoverageModel(),
        competitors = competitors.toCompetitorsModel(),
        venue = venue.toVenueModel()
    )
}
