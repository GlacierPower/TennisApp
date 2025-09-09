package model.player_summaries

import kotlinx.serialization.Serializable

@Serializable
data class CompetitorsTotalModel(
    val id: String,
    val name: String,
    val abbreviation: String,
    val qualifier: String,
    val statistics: TotalStatisticsModel? = null
)
