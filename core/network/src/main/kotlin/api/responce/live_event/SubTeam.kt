package api.responce.live_event

import api.responce.common.Country
import api.responce.common.Sport
import api.responce.common.TeamColor

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
