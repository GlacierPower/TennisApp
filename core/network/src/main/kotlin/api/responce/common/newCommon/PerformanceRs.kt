package api.responce.common.newCommon

import com.squareup.moshi.Json

data class PerformanceRs(
    val total: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    @property:Json(name = "goals_scored")
    val goalsScored: Int,
    @property:Json(name = "goals_conceded")
    val goalsConceded: Int,
    @property:Json(name = "total_points")
    val totalPoints: Int
)
