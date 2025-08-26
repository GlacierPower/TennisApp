package com.glacierpower.tennisapp.model.eventDetailsModel

import com.glacierpower.tennisapp.model.eventModel.*

data class EventDetailsModel(
    val awayScore: ScoreModel,
    val awayTeam: TeamModelLiveEvent,
    val awayTeamSeed: String?,
    val bet365ExcludedCountryCodes: List<String>?,
    val changes: ChangesModel,
    val crowdsourcingDataDisplayEnabled:Boolean,
    val crowdsourcingEnabled:Boolean,
    val currentPeriodStartTimestamp:Long,
    val customId:String,
    val defaultPeriodCount:Int,
    val endTimestamp:Long,
    val fanRatingEvent:Boolean,
    val finalResultOnly:Boolean,
    val firstToServe :Int,
    val groundType:String,
    val hasBet365LiveStream:Boolean,
    val hasGlobalHighlights:Boolean,
    val homeScore: ScoreModel,
    val homeTeam: TeamModelLiveEvent,
    val homeTeamSeed:String?,
    val id:Int,
    val lastPeriod:String?,
    val periods: PeriodsModel,
    val roundInfo: RoundInfoModel?,
    val season: SeasonModel,
    val showTotoPromo:Boolean,
    val slug:String,
    val startTimestamp:Long,
    val status: StatusModel,
    val time: TimeModel,
    val tournament: TournamentModel,
    val venue: VenueModel?,
    val winnerCode:Int
)
