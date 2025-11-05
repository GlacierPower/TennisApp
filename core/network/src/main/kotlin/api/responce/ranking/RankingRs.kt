
package api.responce.ranking

import api.responce.common.Meta

data class RankingRs(
    val data: List<PlayerRankingRs>,
    val meta: Meta,
)
