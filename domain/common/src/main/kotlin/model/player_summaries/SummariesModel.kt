package model.player_summaries

data class SummariesModel(
    val generatedAt: String? = null,
    val sportEvent: SportEventModel,
    val sportEventStatus: SportEventStatusModel,
    val statistics: StatisticsModel?
)
