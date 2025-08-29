package com.glacierpower.tennisapp.model.eventModel

import api.responce.common.Sport
import api.responce.common.TeamColor
import model.CountryModel

data class SubTeamModel(
    val country: CountryModel,
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