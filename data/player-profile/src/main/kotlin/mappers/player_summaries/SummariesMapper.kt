
package mappers.player_summaries

import api.responce.player_summaries.Summaries
import models.player_summaries.SummariesModel

fun List<Summaries>.toListSummariesModel(): List<SummariesModel> {
    return this.map { summaries ->
        SummariesModel(
            sportEvent = summaries.sportEvent.toSportEventModel(),
            sportEventStatus = summaries.sportEventStatus.toSportEventStatusModel(),
            statistics = summaries.statistics.toStatisticsModel()
        )
    }
}
