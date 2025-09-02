package api.responce.player_summaries

import com.squareup.moshi.Json

data class SportEventProperties(
    @property:Json("enhanced_stats")
    val enhancedStats: Boolean,
    val scores: String,
    @property:Json("detailed_serve_outcomes")
    val detailedServeOutcomes: Boolean,
    @property:Json("play_by_play")
    val playByPlay: Boolean
)
