package com.glacierpower.tennisapp.domain.ranking.model

import model.CountryModel
import model.TeamModel

data class RankingModel(
    val typeId:Int,
    val name: String,
    val year: Int,
    val week: Int,
    val gender: String,
    val competitorRankings: List<CompetitorRankingsModel>
)