package com.glacierpower.tennisapp.model.event_statistics_model

data class EventStatisticsModel(
    val statistics: List<StatisticsModel>
)

data class StatisticsModel(
    val period: String,
    val groups: List<GroupsModel>
)

data class GroupsModel(
    val groupName: String,
    val statisticsItemModels: List<StatisticsItemsModel>
)

data class StatisticsItemsModel(
    val name: String,
    val home: String,
    val away: String,
    val compareCode: Int,
    val statisticsType: String,
    val valueType: String,
    val homeValue: Int,
    val awayValue: Int
)