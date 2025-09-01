package models.player_summaries

data class StageModel(
    val order: Int,
    val type: String,
    val phase: String,
    val startDate: String,
    val endDate: String,
    val year: Int
)
