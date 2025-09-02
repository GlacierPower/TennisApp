package api.responce.player_summaries

import com.squareup.moshi.Json

data class PeriodScores(
    @property:Json("home_score")
    val homeScore: Int,
    @property:Json("away_score")
    val awayScore: Int,
    val type: String,
    val number: Int
)
