package mappers.player_summaries

import api.responce.player_summaries.Summaries
import model.player_summaries.SummariesModel

fun Summaries.toListSummariesModel(): SummariesModel {
    return SummariesModel(
        sportEvent = sportEvent.toSportEventModel(),
        sportEventStatus = sportEventStatus.toSportEventStatusModel(),
        statistics = statistics?.toStatisticsModel()
    )
}
