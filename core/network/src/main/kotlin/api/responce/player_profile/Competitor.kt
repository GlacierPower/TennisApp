package api.responce.player_profile

import com.squareup.moshi.Json

data class Competitor(
    val id: String,
    val name: String,
    val country: String,
    @property:Json("country_code")
    val countryCode: String? = null,
    val gender: String? = null,
    val abbreviation: String
)
