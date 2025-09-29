package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class TimeDetailsModel(
    val period1: Int?,
    val period2: Int?,
    val period3: Int?,
    val period4: Int?,
    val period5: Int?,
    val currentPeriodStartTimestamp: Int?
)
