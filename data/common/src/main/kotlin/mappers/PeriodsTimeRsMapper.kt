package mappers

import api.responce.common.PeriodsTimeRs
import kotlinx.serialization.InternalSerializationApi
import model.events.PeriodsTimeModel

@OptIn(InternalSerializationApi::class)
fun List<PeriodsTimeRs>.toPeriodsTimeModel(): List<PeriodsTimeModel> {
    return this.map { period ->
        PeriodsTimeModel(
            period1Time = period.period1Time,
            period2Time = period.period2Time,
            period3Time = period.period3Time,
            period4Time = period.period4Time,
            period5Time = period.period5Time
        )
    }
}
