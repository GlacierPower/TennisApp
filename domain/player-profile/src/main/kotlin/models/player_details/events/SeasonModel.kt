package models.player_details.events

data class SeasonModel(
    val id: Int,
    val leagueId: Int,
    val slug: String,
    val name: String,
    val yearStart: Int,
    val yearEnd: Int?
)
