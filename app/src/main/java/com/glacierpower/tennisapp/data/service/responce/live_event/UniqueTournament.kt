package com.glacierpower.tennisapp.data.service.responce.live_event

import com.glacierpower.tennisapp.data.service.responce.Country

data class UniqueTournament(
    val category: Category,
    val country: Country?,
    val crowdsourcingEnabled:Boolean,
    val displayInverseHomeAwayTeams:Boolean,
    val groundType:String,
    val hasEventPlayerStatistics:Boolean,
    val hasPerformanceGraphFeature:Boolean,
    val id:Int,
    val name:String,
    val primaryColorHex:String?,
    val secondaryColorHex:String?,
    val slug:String,
    val tennisPoints:Int?,
    val userCount:Int
)
