package api.responce.player_summaries

data class SportEventContext(
    val sport: Sport,
    val category: Category,
    val competition: Competition,
    val season: Season,
    val stage: Stage,
    val round: Round,
    val groups: List<Groups>,
    val mode: Mode
)
