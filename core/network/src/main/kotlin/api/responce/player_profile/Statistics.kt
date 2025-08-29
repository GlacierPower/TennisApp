package api.responce.player_profile

import com.squareup.moshi.Json

data class Statistics(
    @property:Json("competitions_played")
    val competitionsPlayed: Int,
    @property:Json("competitions_won")
    val competitionsWon: Int,
    @property:Json("matches_played")
    val matchesPlayed:Int,
    @property:Json("matches_won")
    val matchesWon: Int
)
