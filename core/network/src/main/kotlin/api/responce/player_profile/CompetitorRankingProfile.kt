package api.responce.player_profile

import com.squareup.moshi.Json

data class CompetitorRankingProfile(
    val rank: Int,
    val movement: Int,
    val points: Int,
    @property:Json("competitor_id")
    val competitorId: String,
    val name: String,
    val type: String,
    @property:Json("race_ranking")
    val raceRanking: Boolean
)
