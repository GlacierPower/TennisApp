package com.glacirepower.tennisapp.match_details.mappers

import com.glacirepower.tennisapp.match_details.model.StatisticDvo
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticModel
import utils.toCamelCase
import utils.toStatisticsNumber

fun List<StatisticModel>.toStatisticDvo(): List<StatisticDvo> {
    return this.map { statisticModel ->
        StatisticDvo(
            id = statisticModel.id,
            eventId = statisticModel.eventId,
            period = statisticModel.period,
            group = statisticModel.group.toCamelCase(),
            name = statisticModel.name.toCamelCase(),
            homeValue = statisticModel.home.toStatisticsNumber(),
            homeStat = statisticModel.home,
            awayValue = statisticModel.away.toStatisticsNumber(),
            awayStat = statisticModel.away,
            compareCode = statisticModel.compareCode
        )
    }
}
