
package mappers

import api.responce.common.Country
import model.CountryModel

fun Country.toCountryModel(): CountryModel {
    return CountryModel(
        alpha2 = alpha2,
        alpha3 = alpha3,
        name = name,
        slug = slug
    )
}
