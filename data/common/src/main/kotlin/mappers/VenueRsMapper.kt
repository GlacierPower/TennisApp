package mappers

import api.responce.common.newCommon.VenueRs
import model.common.VenueModel

fun VenueRs.toVenueModel(): VenueModel {
    return VenueModel(
        id = id,
        slug = slug,
        city = city,
        stadium = stadium,
        stadiumCapacity = stadiumCapacity,
        countryName = countryName,
        countryFlag = countryFlag
    )
}
