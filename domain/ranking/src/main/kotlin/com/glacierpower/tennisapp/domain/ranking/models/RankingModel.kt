package com.glacierpower.tennisapp.domain.ranking.models

import com.glacierpower.tennisapp.domain.ranking.model.CompetitorRankingsModel

data class RankingModel(
    val typeId:Int,
    val name: String,
    val year: Int,
    val week: Int,
    val gender: String,
    val competitorRankings: List<CompetitorRankingsModel>
)