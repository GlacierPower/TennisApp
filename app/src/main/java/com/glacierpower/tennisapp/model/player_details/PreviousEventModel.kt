package com.glacierpower.tennisapp.model.player_details

import com.glacierpower.tennisapp.data.service.responce.live_event.Status
import com.glacierpower.tennisapp.model.eventModel.*

data class PreviousEventModel(

    val awayScore: ScoreModel,
    val awayTeam: TeamModelLiveEvent,
    val awayTeamSeed: String?,
    val changes: ChangesModel,
    val crowdsourcingDataDisplayEnabled: Boolean,
    val customId: String,
    val endTimestamp: Long,
    val finalResultOnly: Boolean,
    val firstToServe: Int,
    val groundType: String,
    val hasGlobalHighlights: Boolean,
    val homeScore: ScoreModel,
    val homeTeam: TeamModelLiveEvent,
    val id: Int,
    val periods: PeriodsModel,
    val roundInfo: RoundInfoModel?,
    val slug: String,
    val startTimestamp: Long,
    val status: Status,
    val time: TimeModel,
    val tournament: TournamentModel,
    val winnerCode:Int
)
