package api.responce.player_summaries

import com.squareup.moshi.Json

data class Venue(
    val id: String,
    val name: String,
    @property:Json("city_name")
    val cityName: String,
    @property:Json("country_name")
    val countryName: String,
    @property:Json("country_code")
    val countryCode: String,
    val timezone: String,
    val channels: List<String>,
    val estimated: Boolean
)
