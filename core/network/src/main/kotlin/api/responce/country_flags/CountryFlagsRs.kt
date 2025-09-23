package api.responce.country_flags

import com.squareup.moshi.Json

data class CountryFlagsRs(
    val country: String,
    @property:Json("square_image_url")
    val squareImageUrl: String,
    @property:Json("rectangle_image_url")
    val rectangleImageUrl: String
)
