package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import model.common.SectionModel
import model.common.SportModel

@Serializable
@InternalSerializationApi
data class PlayerEventsDataModel(
    val id: String,
    val sportId: Int,
    val homeTeamId: Int,
    val awayTeamId: Int,
    val leagueId: Int?,
    val challengeId: Int,
    val seasonId: Int?,
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
    val resultOnly: Boolean,
    val coverage: String?,
    val groundType: String?,
    val roundNumber: Int?,
    val seriesCount: Int?,
    val mediasCount: Int?,
    val statusLineUp: String?,
    val firstSupply: Int?,
    val cardsCode: Int?,
    val eventDataChange: Boolean?,
    val lastedPeriod: String?,
    val defaultPeriodCount: Int?,
    val attendance: String?,
    val cupMatchOrder: Int?,
    val cupMatchInRound: Int?,
    val periods: Int?,
    val roundInfo: RoundInfoModel?,
    val periodsTime: List<PeriodsTimeModel>?,
    val mainStat: MainStatModel?,
    val mainOdds: MainOddsModel?,
    val league: LeagueModel,
    val challenge: ChallengeModel,
    val season: SeasonModel,
    val section: SectionModel,
    val sport: SportModel
)
