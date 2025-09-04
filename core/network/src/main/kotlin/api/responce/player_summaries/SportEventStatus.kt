package api.responce.player_summaries

import com.squareup.moshi.Json

data class SportEventStatus(
    val status: String? = null,
    @property:Json("match_status")
    val matchStatus: String? = null,
    @property:Json("home_score")
    val homeScore: Int? = null,
    @property:Json("away_score")
    val awayScore: Int? = null,
    @property:Json("period_scores")
    val periodScores: List<PeriodScores>? = null,
    @property:Json("winner_id")
    val winnerId: String? = null

)
