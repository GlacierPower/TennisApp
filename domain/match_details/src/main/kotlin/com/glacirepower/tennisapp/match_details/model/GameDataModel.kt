package com.glacirepower.tennisapp.match_details.model

data class GameDataModel(
    val game: Int,
    val points: List<PointDataModel>,
    val score: ScoreDataModel
)
