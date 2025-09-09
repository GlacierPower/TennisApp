package model.player_summaries

import kotlinx.serialization.Serializable

@Serializable
data class TotalsModel(
    val competitors: List<CompetitorsTotalModel>
)
