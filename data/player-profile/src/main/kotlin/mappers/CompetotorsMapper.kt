package mappers

import api.responce.player_profile.PlayerProfileResponse
import models.PlayerProfileModel

fun PlayerProfileResponse.toPlayerProfileModel(): PlayerProfileModel{
    return PlayerProfileModel(
        generatedAt = generatedAt,
        competitor = competitor.toCompetitorModel(),
        info = info.toPlayerInfoModel(),
        competitorRankings = competitorRankings.toCompetitorRankingProfileModel(),
        periods = periods.toProfilePeriodsModel(),
        competitionsPlayed = competitionsPlayed.toCompetitionsPlayedModel()
    )
}