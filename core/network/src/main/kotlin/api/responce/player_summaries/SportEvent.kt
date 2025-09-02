package api.responce.player_summaries

import com.squareup.moshi.Json

data class SportEvent(
    val id: String,
    @property:Json("start_time")
    val startTime: String,
    @property:Json("start_time_confirmed")
    val startTimeConfirmed: Boolean,
    @property:Json("sport_event_context")
    val sportEventContext: SportEventContext,
    val coverage: Coverage,
    val competitors: List<Competitors>,
    val venue: Venue
)
