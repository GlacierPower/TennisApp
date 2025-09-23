package model.common

data class PerformanceModel(
    val total: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsScored: Int,
    val goalsConceded: Int,
    val totalPoints: Int
)
