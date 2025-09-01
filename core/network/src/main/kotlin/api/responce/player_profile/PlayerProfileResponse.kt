package api.responce.player_profile

import api.responce.ranking.Competitor
import com.squareup.moshi.Json

data class PlayerProfileResponse(
    @property:Json("generated_at")
    val generatedAt: String,
    val competitor: Competitor,
    val info: PlayerInfo,
    @property:Json("competitor_rankings")
    val competitorRankings: List<CompetitorRankingProfile>,
    val periods: List<ProfilePeriods>,
    @property:Json("competitions_played")
    val competitionsPlayed: List<CompetitionsPlayed>
)