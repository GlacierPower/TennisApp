package models.player_summaries

data class SummariesModel(
    val sportEvent: SportEventModel,
    val sportEventStatus: SportEventStatusModel,
    val statistics: StatisticsModel?
)
