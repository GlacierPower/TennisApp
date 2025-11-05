package api.responce.player_details

import com.squareup.moshi.Json

data class DetailRs(
    val country: String,
    @property:Json("country_i_s_o")
    val countryIso: String,
    @property:Json("date_of_birth")
    val dateOfBirth: String,
    val birthplace: String,
    val plays: String,
    val residence: String,
    val weight: String,
    @property:Json("height_meters")
    val heightMeters: Double,
    @property:Json("prize_current")
    val prizeCurrent: String,
    @property:Json("prize_total")
    val prizeTotal: String,
    @property:Json("prize_current_euros")
    val prizeCurrentEuros: Int,
    @property:Json("prize_total_euros")
    val prizeTotalEuros: Int,
    val flag: String
)
