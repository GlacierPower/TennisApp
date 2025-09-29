package api.responce.player_events

import api.responce.ranking.Meta

data class PlayerEventsRs(
    val data: List<PlayerEventsDataRs>,
    val meta: Meta
)
