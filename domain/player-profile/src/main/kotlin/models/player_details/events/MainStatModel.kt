package models.player_details.events

data class MainStatModel(
    val aces: StatModel?,
    val doubleFaults: StatModel?,
    val firstServe: StatModel?,
    val secondServe: StatModel?
)
