package api.responce

import api.responce.common.Team
import api.responce.live_event.Changes
import api.responce.live_event.Periods
import api.responce.live_event.RoundInfo
import api.responce.live_event.Score
import api.responce.live_event.Status
import api.responce.live_event.Time
import api.responce.live_event.Tournament

data class PlayerLastEventsResponse(
    val events: MutableList<Events>,
    val hasNextPage: Boolean
)

data class Events(
    val awayScore: Score,
    val awayTeam: Team,
    val awayTeamSeed: String,
    val changes: Changes,
    val crowdsourcingDataDisplayEnabled: Boolean,
    val customId: String,
    val finalResultOnly: Boolean,
    val firstToServe: Int,
    val groundType: String,
    val hasGlobalHighlights: Boolean,
    val homeScore: Score,
    val homeTeam: Team,
    val homeTeamSeed: String,
    val id: Int,
    val periods: Periods,
    val roundInfo: RoundInfo?,
    val slug: String,
    val startTimestamp: Long,
    val status: Status,
    val time: Time,
    val tournament: Tournament,
    val winnerCode: Int
)
