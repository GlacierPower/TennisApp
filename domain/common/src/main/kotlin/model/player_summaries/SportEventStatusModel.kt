package model.player_summaries

data class SportEventStatusModel(
    val status: String? = null,
    val matchStatus: String? = null,
    val homeScore: Int? = null,
    val awayScore: Int? = null,
    val periodScores: List<PeriodScoresModel>? = null,
    val winnerId: String? = null
)
