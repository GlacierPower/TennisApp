package models.player_summaries

data class PlayerSummariesModel(
    val generatedAt: String,
    val summaries: List<SummariesModel>
)
