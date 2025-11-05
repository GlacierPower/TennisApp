package api.responce.common

import com.squareup.moshi.Json
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class PeriodsTimeRs(
    @property:Json("period_1_time") val period1Time: Int? = 0,
    @property:Json("period_2_time") val period2Time: Int? = 0,
    @property:Json("period_3_time") val period3Time: Int? = 0,
    @property:Json("period_4_time") val period4Time: Int? = 0,
    @property:Json("period_5_time") val period5Time: Int? = 0
)
