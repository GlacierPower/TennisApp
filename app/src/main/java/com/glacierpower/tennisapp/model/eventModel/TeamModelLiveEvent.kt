package com.glacierpower.tennisapp.model.eventModel

import com.glacierpower.tennisapp.model.rankingModel.ColorModel
import com.glacierpower.tennisapp.model.rankingModel.CountryModel
import com.glacierpower.tennisapp.model.rankingModel.SportModel

data class TeamModelLiveEvent(
    val country: CountryModel?,
    val disabled:Boolean?,
    val fullName:String?,
    val gender:String?,
    val id:Int,
    val name:String,
    val nameCode:String,
    val national:Boolean,
    val playerTeamInfo: PlayerTeamInfoModel?,
    val ranking:Int?,
    val shortName:String,
    val slug:String,
    val sport: SportModel,
    val subTeams:List<SubTeamModel>?,
    val teamColors: ColorModel,
    val type:Int,
    val userCount:Int
)