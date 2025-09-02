package api.responce.player_summaries

import com.squareup.moshi.Json

data class Season(
    val id: String,
    val name: String,
    @property:Json("start_date")
    val startDate: String,
    @property:Json("end_date")
    val endDate: String,
    val year: Int,
    @property:Json("competition_id")
    val competitionId : String
)
