package api.responce.player_events

import com.squareup.moshi.Json

data class MainStatRs(
    val aces: StatRs?,
    @property:Json("double_faults")
    val doubleFaults: StatRs?,
    @property:Json("first_serve")
    val firstServe: StatRs?,
    @property:Json("second_serve")
    val secondServe: StatRs?
)
