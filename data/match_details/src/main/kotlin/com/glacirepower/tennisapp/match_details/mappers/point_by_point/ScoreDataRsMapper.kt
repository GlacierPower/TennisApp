package com.glacirepower.tennisapp.match_details.mappers.point_by_point

import api.responce.point_by_point.ScoreDataRs
import com.glacirepower.tennisapp.match_details.model.ScoreDataModel

fun ScoreDataRs.toScoreDataModel(): ScoreDataModel {
    return ScoreDataModel(
        homeScore = homeScore,
        awayScore = awayScore,
        serving = serving,
        scoring = scoring
    )
}
