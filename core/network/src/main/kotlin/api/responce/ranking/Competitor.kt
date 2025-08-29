package api.responce.ranking

import com.squareup.moshi.Json

data class Competitor(
    val id: String,
    val name: String,
    val country: String,
    @property:Json("country_code")
    val countryCode: String?,
    val abbreviation: String
)
