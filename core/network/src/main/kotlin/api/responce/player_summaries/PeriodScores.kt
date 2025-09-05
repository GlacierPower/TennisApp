package api.responce.player_summaries

import com.squareup.moshi.Json

data class PeriodScores(
    @property:Json("home_score")
    val homeScore: Int? = null,
    @property:Json("away_score")
    val awayScore: Int? = null,
    val type: String? = null,
    val number: Int? = null
)
