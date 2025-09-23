package mappers.events

import api.responce.player_events.TimeDetailsRs
import models.player_details.events.TimeDetailsModel

fun TimeDetailsRs.toTimeDetailsModel(): TimeDetailsModel {
    return TimeDetailsModel(
        period1 = period1,
        period2 = period2,
        period3 = period3,
        period4 = period4,
        period5 = period5,
        currentPeriodStartTimestamp = currentPeriodStartTimestamp
    )
}
