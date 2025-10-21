package api.responce.common

import com.squareup.moshi.Json

data class ScoreRs(
    val current: Int?,
    val display: Int?,
    @property:Json("period_1")val period1: Int?,
    @property:Json("period_2")val period2: Int?,
    @property:Json("period_3")val period3: Int?,
    @property:Json("period_4")val period4: Int?,
    @property:Json("period_5")val period5: Int?,
    @property:Json("normal_time")
    val normalTime: Int?,
    val point: String?,
    @property:Json("period_1_tie_break")
    val period1TieBreak: Int?,
    @property:Json("period_2_tie_break")
    val period2TieBreak: Int?,
    @property:Json("period_3_tie_break")
    val period3TieBreak: Int?,
    @property:Json("period_4_tie_break")
    val period4TieBreak: Int?,
    @property:Json("period_5_tie_break")
    val period5TieBreak: Int?
)
