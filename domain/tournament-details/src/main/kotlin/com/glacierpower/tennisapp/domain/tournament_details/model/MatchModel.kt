package com.glacierpower.tennisapp.domain.tournament_details.model

import model.common.PeriodsModel
import model.common.SectionModel
import model.common.SportModel
import model.events.ChallengeModel
import model.events.LeagueModel
import model.events.MainOddsModel
import model.events.PeriodsTimeModel
import model.events.RoundInfoModel
import model.events.ScoreModel
import model.events.SeasonModel
import model.events.TeamModel
import model.events.TimeDetailsModel

data class MatchModel(
    val id: Int,
    val sportId: Int,
    val homeTeamId: Int,
    val awayTeamId: Int,
    val leagueId: Int,
    val challengeId: Int,
    val seasonId: Int,
    val venueId: Int?,
    val refereeId: Int?,
    val slug: String,
    val name: String,
    val status: String,
    val statusMore: String?,
    val timeDetails: TimeDetailsModel?,
    val homeTeam: TeamModel,
    val awayTeam: TeamModel,
    val startAt: String,
    val priority: Int,
    val homeScore: ScoreModel?,
    val awayScore: ScoreModel?,
    val winnerCode: Int?,
    val aggregatedWinnerCode: Int?,
    val resultOnly: Boolean?,
    val coverage: String?,
    val groundType: String?,
    val roundNumber: Int?,
    val seriesCount: Int?,
    val mediasCount: Int?,
    val statusLineup: String?,
    val firstSupply: Int?,
    val cardsCode: String?,
    val eventDataChange: String?,
    val lastedPeriod: String?,
    val defaultPeriodCount: Int?,
    val attendance: Int?,
    val cupMatchOrder: Int?,
    val cupMatchInRound: Int?,
    val periods: PeriodsModel?,
    val roundInfo: RoundInfoModel?,
    val periodsTime: List<PeriodsTimeModel>?,
    val mainOdds: MainOddsModel?,
    val league: LeagueModel?,
    val challenge: ChallengeModel?,
    val season: SeasonModel?,
    val section: SectionModel?,
    val sport: SportModel?
)
