package api.responce.player_details

import com.squareup.moshi.Json

data class TennisRankingRs(
    val id: Int,
    val type: String,
    val points: String,
    val ranking: Int,
    val tournaments: String?,
    @property:Json("official_updated_at")
    val officialUpdatedAt: String
)
