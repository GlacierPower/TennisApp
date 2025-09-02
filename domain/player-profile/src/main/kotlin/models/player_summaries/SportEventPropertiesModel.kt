package models.player_summaries

data class SportEventPropertiesModel(
    val enhancedStats: Boolean,
    val scores: String,
    val detailedServeOutcomes: Boolean,
    val playByPlay: Boolean
)
