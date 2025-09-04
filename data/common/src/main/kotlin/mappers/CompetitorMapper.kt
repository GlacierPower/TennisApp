
package mappers

import api.responce.ranking.Competitor
import model.CompetitorModel
import utils.formatName

fun Competitor.toCompetitorModel(): CompetitorModel {
    return CompetitorModel(
        id = id,
        name = name.formatName(),
        country = country,
        countryCode = country,
        abbreviation = abbreviation
    )
}
