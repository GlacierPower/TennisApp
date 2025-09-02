package models.player_summaries

data class CompetitorsModel(
    val id: String,
    val name: String,
    val country: String,
    val abbreviation: String,
    val qualifier: String,
    val seed: Int,
    val bracketNumber: Int
)
