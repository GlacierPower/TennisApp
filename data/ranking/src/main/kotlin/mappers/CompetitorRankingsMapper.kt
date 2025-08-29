package mappers

import api.responce.ranking.CompetitorRankings
import com.glacierpower.tennisapp.domain.ranking.model.CompetitorRankingsModel

fun CompetitorRankings.toCompetitorRankingsModel(): CompetitorRankingsModel {
    return CompetitorRankingsModel(
        rank = rank,
        movement = movement,
        points = points,
        competitionsPlayed = competitionsPlayed,
        competitor = competitor.toCompetitorModel()
    )
}