
package mappers.player_summaries

import api.responce.player_summaries.Venue
import models.player_summaries.VenueModel

fun Venue.toVenueModel(): VenueModel {
    return VenueModel(
        id = id,
        name = name,
        cityName = cityName,
        countryName = countryName,
        countryCode = countryCode,
        timezone = timezone,
        channels = channels?.toChannelModel(),
        estimated = estimated
    )
}
