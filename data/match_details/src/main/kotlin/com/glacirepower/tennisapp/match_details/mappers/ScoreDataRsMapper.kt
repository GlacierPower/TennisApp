package com.glacirepower.tennisapp.match_details.mappers

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
