package model.common

data class VenueModel(
    val id: Int,
    val slug: String,
    val city: Map<String, String>,
    val stadium: Map<String, String>,
    val stadiumCapacity: Int,
    val countryName: String,
    val countryFlag: String
)
