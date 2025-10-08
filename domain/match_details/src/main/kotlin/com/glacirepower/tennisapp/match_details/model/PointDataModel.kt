package com.glacirepower.tennisapp.match_details.model

data class PointDataModel(
    val homePoint: String,
    val awayPoint: String,
    val pointDescription: Int,
    val homePointType: Int,
    val awayPointType: Int
)
