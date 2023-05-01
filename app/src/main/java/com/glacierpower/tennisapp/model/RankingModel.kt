package com.glacierpower.tennisapp.model

data class RankingModel(
    val bestRanking: Int,
    val bestRankingDateTimestamp: Int,
    val country: String? = null,
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