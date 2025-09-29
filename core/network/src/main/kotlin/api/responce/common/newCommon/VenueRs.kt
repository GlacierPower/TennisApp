package api.responce.common.newCommon

import com.squareup.moshi.Json

data class VenueRs(
    val id: Int,
    val slug: String,
    val city: Map<String, String>,
    val stadium: Map<String, String>,
    @property:Json(name = "stadium_capacity")
    val stadiumCapacity: Int,
    @property:Json(name = "country_name")
    val countryName: String,
    @property:Json(name = "country_flag")
    val countryFlag: String
)
