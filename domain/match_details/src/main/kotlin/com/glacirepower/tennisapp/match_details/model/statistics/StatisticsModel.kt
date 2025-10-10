package com.glacirepower.tennisapp.match_details.model.statistics

import model.events.MetaModel

data class StatisticsModel(
    val data: List<StatisticModel>,
    val meta: MetaModel? = null
)
