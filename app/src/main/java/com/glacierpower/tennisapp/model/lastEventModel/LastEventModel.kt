package com.glacierpower.tennisapp.model.lastEventModel

import com.glacierpower.tennisapp.data.service.responce.live_event.*
import com.glacierpower.tennisapp.model.eventModel.*
import com.glacierpower.tennisapp.model.rankingModel.TeamModel

data class LastEventModel(
    val awayScore: ScoreModel?,
    val awayTeam:TeamModel,
    val awayTeamSeed:String?,
    val changes: ChangesModel,
    val crowdsourcingDataDisplayEnabled:Boolean,
    val customId:String,
    val finalResultOnly:Boolean,
    val firstToServe:Int,
    val groundType:String,
    val hasGlobalHighlights:Boolean,
    val homeScore: ScoreModel,
    val homeTeam:TeamModel,
    val homeTeamSeed:String?,
    val id:Int,
    val periods: PeriodsModel,
    val roundInfo: RoundInfoModel?,
    val slug:String,
    val startTimestamp:Long,
    val status: Status,
    val time: TimeModel,
    val tournament: TournamentModel,
    val winnerCode:Int
)
