package api.responce.player_summaries

import com.squareup.moshi.Json

data class SportEventStatus(
    val status: String,
    @property:Json("match_status")
    val matchStatus: String,
    @property:Json("home_score")
    val homeScore: Int,
    @property:Json("away_score")
    val awayScore: Int,
    @property:Json("period_scores")
    val periodScores: List<PeriodScores>,
    @property:Json("winner_id")
    val winnerId: String

)
