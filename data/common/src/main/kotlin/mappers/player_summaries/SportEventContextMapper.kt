
package mappers.player_summaries

import api.responce.player_summaries.SportEventContext
import model.player_summaries.SportEventContextModel

fun SportEventContext.toSportEventContextModel(): SportEventContextModel {
    return SportEventContextModel(
        sport = sport.toSportModel(),
        category = category.toCategoryModel(),
        competition = competition.toCompetitionModel(),
        season = season.toSeasonModel(),
        stage = stage.toStageModel(),
        round = round.toRoundModel(),
        groups = groups.toGroupsModel(),
        mode = mode.toModeModel()
    )
}
