package com.glacierpower.tennisapp.data.service.responce.player_details

data class PlayerTeamInfoDetails(
    val birthDateTimestamp:Long,
    val birthplace:String,
    val currentRanking:Int,
    val height:Float,
    val id:Int,
    val plays:String,
    val prizeCurrent:String,
    val prizeCurrentRaw:PrizeCurrentRaw,
    val prizeTotal:Int,
    val prizeTotalRaw:PrizeCurrentRaw,
    val residence:String,
    val turnedPro:String,
    val weight:Int
)
