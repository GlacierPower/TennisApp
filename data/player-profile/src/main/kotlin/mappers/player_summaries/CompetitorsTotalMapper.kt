package mappers.player_summaries

import api.responce.player_summaries.CompetitorsTotal
import models.player_summaries.CompetitorsTotalModel

fun List<CompetitorsTotal>.toCompetitorsTotalModel(): List<CompetitorsTotalModel> {
    return this.map { competitorsTotal ->
        CompetitorsTotalModel(
            id = competitorsTotal.id,
            name = competitorsTotal.name,
            abbreviation = competitorsTotal.abbreviation,
            qualifier = competitorsTotal.qualifier,
            statistics = competitorsTotal.statistics.toTotalStatisticsModel()
        )
    }
}