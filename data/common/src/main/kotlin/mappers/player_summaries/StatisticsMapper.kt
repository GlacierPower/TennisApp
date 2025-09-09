
package mappers.player_summaries

import api.responce.player_summaries.Statistics
import model.player_summaries.StatisticsModel

fun Statistics.toStatisticsModel(): StatisticsModel {
    return StatisticsModel(
        totals = totals.toTotalsModel()
    )
}
