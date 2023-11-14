package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.event_statistics_response.EventStatisticsResponse
import com.glacierpower.tennisapp.data.service.responce.event_statistics_response.Groups
import com.glacierpower.tennisapp.data.service.responce.event_statistics_response.Statistics
import com.glacierpower.tennisapp.data.service.responce.event_statistics_response.StatisticsItems
import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import com.glacierpower.tennisapp.model.event_statistics_model.GroupsModel
import com.glacierpower.tennisapp.model.event_statistics_model.StatisticsItemsModel
import com.glacierpower.tennisapp.model.event_statistics_model.StatisticsModel

fun EventStatisticsResponse.toEntity(): EventStatisticsModel {
    return EventStatisticsModel(
        statistics.map { statistics ->
            statistics.toEntity()
        }
    )
}

fun Statistics.toEntity(): StatisticsModel {
    return StatisticsModel(
        period,
        groups.map { groups ->
            groups.toEntity()
        }
    )
}

fun Groups.toEntity(): GroupsModel {
    return GroupsModel(
        groupName,
        statisticsItems.map { statisticsItems ->
            statisticsItems.toEntity()
        }
    )
}

fun StatisticsItems.toEntity(): StatisticsItemsModel {
    return StatisticsItemsModel(
        name,
        home, away, compareCode, statisticsType, valueType, homeValue, awayValue
    )
}
