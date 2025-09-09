package api.responce.player_summaries

import com.squareup.moshi.Json

data class Summaries(
    @property:Json("generated_at")
    val generatedAt: String? = null,
    @property:Json("sport_event")
    val sportEvent: SportEvent,
    @property:Json("sport_event_status")
    val sportEventStatus: SportEventStatus,
    val statistics: Statistics?
)
