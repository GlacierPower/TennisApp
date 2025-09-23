package models.player_details.details

data class TennisRankingModel(
    val id: Int,
    val type: String,
    val points: String,
    val ranking: Int,
    val tournaments: String?,
    val officialUpdatedAt: String
)
