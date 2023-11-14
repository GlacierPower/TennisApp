package com.glacierpower.tennisapp.domain.event_statistics

import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import com.glacierpower.tennisapp.utils.ResultState

interface EventStatisticsRepository {

    suspend fun getEventStatistics(id: Int):ResultState<EventStatisticsModel>
}