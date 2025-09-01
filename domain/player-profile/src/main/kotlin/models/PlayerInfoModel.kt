package models

data class PlayerInfoModel(
    val proYear: Int,
    val handedness: String,
    val highestSinglesRanking: Int,
    val highestDoublesRanking: Int?,
    val weight: Int,
    val height: Int,
    val dateOfBirth: String,
    val highestSinglesRankingDate: String,
    val highestDoublesRankingDate: String?
)
