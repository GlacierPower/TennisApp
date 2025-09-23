package api.responce.player_events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class PeriodsTimeRs(
    @SerialName("period_1_time") val period1Time: Int? = 0,
    @SerialName("period_2_time") val period2Time: Int? = 0,
    @SerialName("period_3_time") val period3Time: Int? = 0,
    @SerialName("period_4_time") val period4Time: Int? = 0,
    @SerialName("period_5_time") val period5Time: Int? = 0
)
