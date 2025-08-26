package com.glacierpower.tennisapp.model.player_details

data class PlayerTeamInfoDetailsModel(
    val birthDateTimestamp:Long,
    val birthplace:String,
    val currentRanking:Int,
    val height:Float,
    val id:Int,
    val plays:String,
    val prizeCurrent:String,
    val prizeCurrentRaw: PrizeCurrentRawModel,
    val prizeTotal:Int,
    val prizeTotalRaw: PrizeCurrentRawModel,
    val residence:String,
    val turnedPro:String,
    val weight:Int?
)
