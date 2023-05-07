package com.glacierpower.tennisapp.model

import com.glacierpower.tennisapp.data.service.responce.Country

data class RankingModel(
    val bestRanking: Int,
    val bestRankingDateTimestamp: Int,
    val country: Country,
    val id: Int,
    val points: Int,
    val previousPoints: Int,
    val previousRanking: Int,
    val ranking: Int,
    val rankingClass: String,
    val rowName: String,
    val team: TeamModel,
    val tournamentsPlayed: Int,
    val type: Int
)