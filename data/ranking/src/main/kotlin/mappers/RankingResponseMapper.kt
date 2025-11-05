package mappers

import api.responce.ranking.PlayerRankingRs
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel

fun List<PlayerRankingRs>.toRankingsModel(): List<RankingModel> {
    return this.map { rank ->
        RankingModel(
            id = rank.id,
            type = rank.type,
            points = rank.points,
            ranking = rank.ranking,
            tournaments = rank.tournaments,
            officialUpdatedAt = rank.officialUpdatedAt,
            team = rank.team.toTeamModel()
        )
    }
}
