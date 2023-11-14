package com.glacierpower.tennisapp.data.service.responce.event_statistics_response

data class EventStatisticsResponse(
    val statistics: List<Statistics>
)

data class Statistics(
    val period: String,
    val groups: List<Groups>
)

data class Groups(
    val groupName: String,
    val statisticsItems: List<StatisticsItems>
)

data class StatisticsItems(
    val name: String,
    val home: String,
    val away: String,
    val compareCode: Int,
    val statisticsType: String,
    val valueType: String,
    val homeValue: Int,
    val awayValue: Int
)
