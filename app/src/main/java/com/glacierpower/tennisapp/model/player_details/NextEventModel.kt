package com.glacierpower.tennisapp.model.player_details

import com.glacierpower.tennisapp.data.service.responce.live_event.*
import com.glacierpower.tennisapp.model.eventModel.*
import com.glacierpower.tennisapp.model.rankingModel.TeamModel

data class NextEventModel(
    val awayScore: ScoreModel?,
    val awayTeam: TeamModelLiveEvent,
    val changes: ChangesModel,
    val crowdsourcingDataDisplayEnabled: Boolean,
    val customId: String,
    val finalResultOnly: Boolean,
    val groundType: String,
    val hasGlobalHighlights: Boolean,
    val homeScore: ScoreModel?,
    val homeTeam: TeamModelLiveEvent?,
    val homeTeamSeed: String?,
    val id: Int,
    val periods: PeriodsModel,
    val roundInfo: RoundInfoModel,
    val slug: String,
    val startTimestamp: Long,
    val status: Status,
    val time: TimeModel?,
    val tournament: TournamentModel
)