package models.player_summaries

data class CompetitionModel(
    val id: String,
    val name: String,
    val parentId: String,
    val type: String,
    val gender: String,
    val level: String
)
