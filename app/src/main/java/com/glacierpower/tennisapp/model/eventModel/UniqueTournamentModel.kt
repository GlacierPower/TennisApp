package com.glacierpower.tennisapp.model.eventModel

import com.glacierpower.tennisapp.data.service.responce.Events.Category

data class UniqueTournamentModel(
    val category: CategoryModel,
    val country: Any?,
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
