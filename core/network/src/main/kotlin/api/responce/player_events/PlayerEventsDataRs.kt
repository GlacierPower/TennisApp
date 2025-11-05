package api.responce.player_events

import api.responce.common.ChallengeRs
import api.responce.common.LeagueRs
import api.responce.common.MainOddsRs
import api.responce.common.PeriodsTimeRs
import api.responce.common.RoundInfoRs
import api.responce.common.ScoreRs
import api.responce.common.SeasonRs
import api.responce.common.TimeDetailsRs
import api.responce.common.SectionRs
import api.responce.common.SportRs
import api.responce.common.TeamRs
import com.squareup.moshi.Json
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PlayerEventsDataRs
@OptIn(InternalSerializationApi::class)
constructor(
    val id: String,
    @property:Json(name = "sport_id")
    val sportId: Int,
    @property:Json("home_team_id")
    val homeTeamId: Int,
    @property:Json("away_team_id")
    val awayTeamId: Int,
    @property:Json("league_id")
    val leagueId: Int?,
    @property:Json("challenge_id")
    val challengeId: Int,
    @property:Json("season_id")
    val seasonId: Int?,
    @property:Json("venue_id")
    val venueId: Int?,
    @property:Json("referee_id")
    val refereeId: Int?,
    val slug: String,
    val name: String,
    val status: String,
    @property:Json("status_more")
    val statusMore: String?,
    @property:Json("time_details")
    val timeDetails: TimeDetailsRs?,
    @property:Json("home_team")
    val homeTeam: TeamRs,
    @property:Json("away_team")
    val awayTeam: TeamRs,
    @property:Json("start_at")
    val startAt: String,
    val priority: Int,
    @property:Json("home_score")
    val homeScore: ScoreRs?,
    @property:Json("away_score")
    val awayScore: ScoreRs?,
    @property:Json("winner_code")
    val winnerCode: Int?,
    @property:Json("aggregated_winner_code")
    val aggregatedWinnerCode: Int?,
    @property:Json("result_only")
    val resultOnly: Boolean,
    val coverage: String?,
    @property:Json("ground_type")
    val groundType: String?,
    @property:Json("round_number")
    val roundNumber: Int?,
    @property:Json("series_count")
    val seriesCount: Int?,
    @property:Json("medias_count")
    val mediasCount: Int?,
    @property:Json("status_lineup")
    val statusLineUp: String?,
    @property:Json("first_supply")
    val firstSupply: Int?,
    @property:Json("cards_code")
    val cardsCode: Int?,
    @property:Json("event_data_change")
    val eventDataChange: Boolean?,
    @property:Json("lasted_period")
    val lastedPeriod: String?,
    @property:Json("default_period_count")
    val defaultPeriodCount: Int?,
    val attendance: String?,
    @property:Json("cup_match_order")
    val cupMatchOrder: Int?,
    @property:Json("cup_match_in_round")
    val cupMatchInRound: Int?,
    val periods: Int?,
    @property:Json("round_info")
    val roundInfo: RoundInfoRs?,
    @InternalSerializationApi
    @SerialName("periods_time")
    @Serializable(with = PeriodsTimeListSerializer::class)
    val periodsTime: List<PeriodsTimeRs> = emptyList(),
    @property:Json("main_stat")
    val mainStat: MainStatRs?,
    @property:Json("main_odds")
    val mainOdds: MainOddsRs?,
    val league: LeagueRs,
    val challenge: ChallengeRs,
    val season: SeasonRs,
    val section: SectionRs,
    val sport: SportRs
)
