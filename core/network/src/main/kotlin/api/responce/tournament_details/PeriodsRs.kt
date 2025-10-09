package api.responce.tournament_details

import kotlinx.serialization.SerialName

data class PeriodsRs(
    val current: String?,
    @SerialName("period_1")val period1: String?,
    @SerialName("period_2")val period2: String?,
    @SerialName("period_3")val period3: String?,
    @SerialName("period_4")val period4: String?,
    @SerialName("period_5")val period5: String?,
    val point: String?
)
