package api.responce.player_events

import api.responce.common.Meta

data class PlayerEventsRs(
    val data: List<PlayerEventsDataRs>,
    val meta: Meta
)
