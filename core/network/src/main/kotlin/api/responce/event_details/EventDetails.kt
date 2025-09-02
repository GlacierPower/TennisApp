package api.responce.event_details

import api.responce.common.Team
import api.responce.live_event.Changes
import api.responce.live_event.Periods
import api.responce.live_event.RoundInfo
import api.responce.live_event.Score
import api.responce.live_event.Status
import api.responce.live_event.Time
import api.responce.live_event.Tournament

data class EventDetails(
    val awayScore: Score,
    val awayTeam: Team,
    val awayTeamSeed: String,
    val bet365ExcludedCountryCodes: List<String>,
    val changes: Changes,
    val crowdsourcingDataDisplayEnabled: Boolean,
    val crowdsourcingEnabled: Boolean,
    val currentPeriodStartTimestamp: Long,
    val customId: String,
    val defaultPeriodCount: Int,
    val endTimestamp: Long,
    val fanRatingEvent: Boolean,
    val finalResultOnly: Boolean,
    val firstToServe: Int,
    val groundType: String,
    val hasBet365LiveStream: Boolean,
    val hasGlobalHighlights: Boolean,
    val homeScore: Score,
    val homeTeam: Team,
    val homeTeamSeed: String,
    val id: Int,
    val lastPeriod: String?,
    val periods: Periods,
    val roundInfo: RoundInfo?,
    val season: Season,
    val showTotoPromo: Boolean,
    val slug: String,
    val startTimestamp: Long,
    val status: Status,
    val time: Time,
    val tournament: Tournament,
    val venue: Venue?,
    val winnerCode: Int
)
