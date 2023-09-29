package com.glacierpower.tennisapp.model.eventModel

import com.glacierpower.tennisapp.data.service.responce.Events.*

data class EventModel(
    val awayScore: ScoreModel,
    val awayTeam: TeamModelLiveEvent,
    val changes: ChangesModel,
    val crowdsourcingDataDisplayEnabled: Boolean,
    val customId: String,
    val finalResultOnly: Boolean,
    val firstToServe: Int?,
    val groundType: String,
    val hasGlobalHighlights: Boolean,
    val homeScore: ScoreModel,
    val homeTeam: TeamModelLiveEvent,
    val homeTeamSeed: String?,
    val id: Int,
    val lastPeriod: String,
    val periods: PeriodsModel,
    val roundInfo: RoundInfoModel,
    val slug: String,
    val startTimestamp: Int,
    val status: Status,
    val time: TimeModel,
    val tournament: TournamentModel
)
