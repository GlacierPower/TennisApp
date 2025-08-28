package mappers

import api.responce.ranking.Rankings
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel

fun Rankings.toRankingModel(): RankingModel {
    return RankingModel(
        typeId = typeId,
        name = name,
        year = year,
        week = week,
        gender = gender,
        competitorRankings = competitorRankings.map { it.toCompetitorRankingsModel() }
    )
}
