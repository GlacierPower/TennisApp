package com.glacierpower.tennisapp.data.service.responce.Events

import com.glacierpower.tennisapp.data.service.responce.Country
import com.glacierpower.tennisapp.data.service.responce.Sport
import com.glacierpower.tennisapp.data.service.responce.TeamColor

data class SubTeam(
    val country: Country,
    val gender:String,
    val id :Int,
    val name:String,
    val nameCode:String,
    val national :Boolean,
    val ranking:Int,
    val shortName:String,
    val slug:String,
    val sport: Sport,
    val subTeam:List<Any>,
    val teamColor: TeamColor,
    val type:Int,
    val userCount:Int
)
