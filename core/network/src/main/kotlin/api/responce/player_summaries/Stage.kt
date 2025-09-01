package api.responce.player_summaries

import com.squareup.moshi.Json

data class Stage(
    val order: Int,
    val type: String,
    val phase: String,
    @property:Json("start_date")
    val startDate: String,
    @property:Json("end_date")
    val endDate: String,
    val year: Int
)
