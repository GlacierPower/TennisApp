package models.player_summaries

data class VenueModel(
    val id: String,
    val name: String,
    val cityName: String,
    val countryName: String,
    val countryCode: String,
    val timezone: String,
    val channels: List<ChannelsModel>? = null,
    val estimated: Boolean? = null
)
