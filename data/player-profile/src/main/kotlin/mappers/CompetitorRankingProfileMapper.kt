package mappers

import api.responce.player_profile.CompetitorRankingProfile
import models.CompetitorRankingProfileModel

fun List<CompetitorRankingProfile>.toCompetitorRankingProfileModel(): List<CompetitorRankingProfileModel> {
    return this.map { competitorRankingProfile ->
        CompetitorRankingProfileModel(
            rank = competitorRankingProfile.rank,
            movement = competitorRankingProfile.movement,
            points = competitorRankingProfile.points,
            competitorId = competitorRankingProfile.competitorId,
            name = competitorRankingProfile.name,
            type = competitorRankingProfile.type,
            raceRanking = competitorRankingProfile.raceRanking
        )
    }
}
