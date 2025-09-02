package api.responce.player_summaries

import com.squareup.moshi.Json

data class PlayerSummariesResponse(
    @property:Json("generated_at")
    val generatedAt: String,
    val summaries: List<Summaries>
)
