package models.player_details.events

data class RoundInfoModel(
    val round: Int,
    val name: String?,
    val cupRoundType: Int?
)
