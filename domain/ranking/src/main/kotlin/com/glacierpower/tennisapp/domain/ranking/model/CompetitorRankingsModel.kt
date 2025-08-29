package com.glacierpower.tennisapp.domain.ranking.model

data class CompetitorRankingsModel(
    val rank:Int,
    val movement:Int,
    val points:Int,
    val competitionsPlayed:Int,
    val competitor: CompetitorModel
)
