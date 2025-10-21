package api.responce.statistics

import api.responce.common.Meta

data class StatisticsRs(
    val data: List<StatisticRs>,
    val meta: Meta? = null
)
