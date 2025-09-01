package models

import model.CompetitorModel

data class PlayerProfileModel(
    val generatedAt: String,
    val competitor: CompetitorModel,
    val info: PlayerInfoModel,
    val competitorRankings: List<CompetitorRankingProfileModel>,
    val periods: List<ProfilePeriodsModel>,
    val competitionsPlayed:CompetitionsPlayedModel
)
