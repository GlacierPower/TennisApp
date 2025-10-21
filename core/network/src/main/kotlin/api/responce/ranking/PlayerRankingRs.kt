package api.responce.ranking

import api.responce.common.TeamRs
import com.squareup.moshi.Json

data class PlayerRankingRs(
    val id: Int,
    val type: String,
    val points: Int,
    val ranking: Int,
    val tournaments: Int?,
    @property:Json(name = "official_updated_at")
    val officialUpdatedAt: String,
    val team: TeamRs
)
