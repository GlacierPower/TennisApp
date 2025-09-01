package api.responce.player_summaries

import com.squareup.moshi.Json

data class Coverage(
    val type: String,
    @property:Json("sport_event_properties")
    val sportEventProperties: SportEventProperties
)
