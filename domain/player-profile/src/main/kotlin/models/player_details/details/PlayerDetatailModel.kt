package models.player_details.details

data class PlayerDetailModel(
    val country: String,
    val countryIso: String,
    val dateOfBirth: String,
    val birthplace: String,
    val plays: String,
    val residence: String,
    val weight: String,
    val heightMeters: Double,
    val prizeCurrent: String,
    val prizeTotal: String,
    val prizeCurrentEuros: Int,
    val prizeTotalEuros: Int,
    val flag: String
)
