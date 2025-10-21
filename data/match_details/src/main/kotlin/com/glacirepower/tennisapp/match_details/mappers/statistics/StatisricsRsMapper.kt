package com.glacirepower.tennisapp.match_details.mappers.statistics

import api.responce.statistics.StatisticsRs
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticsModel
import mappers.toMetaModel

fun StatisticsRs.toStatisticsModel(): StatisticsModel {
    return StatisticsModel(
        data = data.toStatisticModel(),
        meta = meta?.toMetaModel()
    )
}
