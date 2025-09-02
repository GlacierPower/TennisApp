package mappers.player_summaries

import api.responce.player_summaries.Competitors
import models.player_summaries.CompetitorsModel

fun List<Competitors>.toCompetitorsModel(): List<CompetitorsModel> {
    return this.map { competitors ->
        CompetitorsModel(
            id = competitors.id,
            name = competitors.name,
            country = competitors.country,
            abbreviation = competitors.abbreviation,
            qualifier = competitors.qualifier,
            seed = competitors.seed,
            bracketNumber = competitors.bracketNumber
        )
    }
}