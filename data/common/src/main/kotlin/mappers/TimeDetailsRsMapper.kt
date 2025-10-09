package mappers

import api.responce.common.TimeDetailsRs
import kotlinx.serialization.InternalSerializationApi
import model.events.TimeDetailsModel

@OptIn(InternalSerializationApi::class)
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
