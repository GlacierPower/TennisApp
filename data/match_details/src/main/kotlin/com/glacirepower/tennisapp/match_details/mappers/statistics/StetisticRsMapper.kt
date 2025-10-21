package com.glacirepower.tennisapp.match_details.mappers.statistics

import api.responce.statistics.StatisticRs
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticModel

fun List<StatisticRs>.toStatisticModel(): List<StatisticModel> {
    return this.map { stat ->
        StatisticModel(
            id = stat.id,
            eventId = stat.eventId,
            period = stat.period,
            group = stat.group,
            name = stat.name,
            home = stat.home,
            away = stat.away,
            compareCode = stat.compareCode
        )
    }
}
