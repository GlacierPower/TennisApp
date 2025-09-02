package models.player_summaries

data class CompetitorsTotalModel(
    val id: String,
    val name: String,
    val abbreviation: String,
    val qualifier: String,
    val statistics: TotalStatisticsModel
)
