package com.glacierpower.tennisapp.data.service.responce.Events

import com.glacierpower.tennisapp.data.service.responce.Country
import com.glacierpower.tennisapp.data.service.responce.Sport
import com.glacierpower.tennisapp.data.service.responce.TeamColor

data class Team(
    val country: Country?,
    val disabled:Boolean?,
    val gender:String,
    val id:Int,
    val name:String,
    val nameCode:String,
    val national:Boolean,
    val playerTeamInfo:PlayerTeamInfo?,
    val ranking:Int?,
    val shortName:String,
    val slug:String,
    val sport: Sport,
    val subTeam:List<SubTeam>?,
    val teamColors:TeamColor,
    val type:Int,
    val userCount:Int



)
