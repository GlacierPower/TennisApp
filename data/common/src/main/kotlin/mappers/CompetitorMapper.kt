package mappers

import api.responce.ranking.Competitor
import model.CompetitorModel

fun Competitor.toCompetitorModel() : CompetitorModel {
    return CompetitorModel(
        id = id,
        name = name,
        country = country,
        countryCode = country,
        abbreviation = abbreviation
    )
}