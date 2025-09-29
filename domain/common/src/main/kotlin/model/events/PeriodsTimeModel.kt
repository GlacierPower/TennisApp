package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class PeriodsTimeModel(
    val period1Time: Int?,
    val period2Time: Int?,
    val period3Time: Int?,
    val period4Time: Int?,
    val period5Time: Int?
)
