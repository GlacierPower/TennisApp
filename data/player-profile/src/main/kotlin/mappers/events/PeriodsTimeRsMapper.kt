package mappers.events

import api.responce.player_events.PeriodsTimeRs
import models.player_details.events.PeriodsTimeModel

fun PeriodsTimeRs.toPeriodsTimeModel(): PeriodsTimeModel {
    return PeriodsTimeModel(
        period1Time = period1Time,
        period2Time = period2Time,
        period3Time = period3Time,
        period4Time = period4Time,
        period5Time = period5Time
    )
}
