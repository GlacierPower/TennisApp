package mappers

import api.responce.country_flags.CountryFlagsRs
import model.common.CountryFlagsModel

fun List<CountryFlagsRs>.toCountryFlagsModel(): List<CountryFlagsModel> {
    return this.map { flag ->
        CountryFlagsModel(
            country = flag.country,
            rectangleImageUrl = flag.rectangleImageUrl,
            squareImageUrl = flag.squareImageUrl
        )
    }
}
