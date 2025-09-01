package models

data class CompetitorRankingProfileModel(
    val rank: Int,
    val movement: Int,
    val points: Int,
    val competitorId: String,
    val name: String,
    val type: String,
    val raceRanking: Boolean
)
