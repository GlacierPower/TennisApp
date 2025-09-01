package api.responce.player_profile

import com.squareup.moshi.Json

data class PlayerInfo(
    @property:Json("pro_year")
    val proYear: Int,
    val handedness: String,
    @property:Json("highest_singles_ranking")
    val highestSinglesRanking: Int,
    @property:Json("highest_doubles_ranking")
    val highestDoublesRanking: Int?,
    val weight: Int,
    val height: Int,
    @property:Json("date_of_birth")
    val dateOfBirth: String,
    @property:Json("highest_singles_ranking_date")
    val highestSinglesRankingDate: String,
    @property:Json("highest_doubles_ranking_date")
    val highestDoublesRankingDate: String?
)
