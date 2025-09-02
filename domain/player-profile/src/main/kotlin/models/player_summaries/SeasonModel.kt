package models.player_summaries

data class SeasonModel(
    val id: String,
    val name: String,
    val startDate: String,
    val endDate: String,
    val year: Int,
    val competitionId : String
)
