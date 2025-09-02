package models.player_summaries

data class SportEventStatusModel(
    val status: String,
    val matchStatus: String,
    val homeScore: Int,
    val awayScore: Int,
    val periodScores: List<PeriodScoresModel>,
    val winnerId: String
)
