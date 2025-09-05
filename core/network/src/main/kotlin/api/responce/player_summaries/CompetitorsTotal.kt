package api.responce.player_summaries

data class CompetitorsTotal(
    val id: String,
    val name: String,
    val abbreviation: String,
    val qualifier: String,
    val statistics: TotalStatistics? = null
)
