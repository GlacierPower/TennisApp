package api.responce.tournament_details

import api.responce.common.Meta

data class TournamentRs(
    val data: List<MatchRs>,
    val meta: Meta
)
