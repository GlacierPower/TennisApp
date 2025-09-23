package api.responce.player_events

import com.squareup.moshi.Json

data class SeasonRs(
    val id: Int,
    @property:Json("league_id")
    val leagueId: Int,
    val slug: String,
    val name: String,
    @property:Json("year_start")
    val yearStart: Int,
    @property:Json("year_end")
    val yearEnd: Int?
)
