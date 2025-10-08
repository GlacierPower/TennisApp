package com.glacirepower.tennisapp.match_details.mappers

import api.responce.point_by_point.GameDataRs
import com.glacirepower.tennisapp.match_details.model.GameDataModel

fun List<GameDataRs>.toGameDataModel(): List<GameDataModel> {
    return this.map { gameDataRs ->
        GameDataModel(
            game = gameDataRs.game,
            points = gameDataRs.points.toPointDataModel(),
            score = gameDataRs.score.toScoreDataModel()
        )
    }
}
