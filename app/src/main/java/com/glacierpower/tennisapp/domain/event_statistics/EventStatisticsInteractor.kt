package com.glacierpower.tennisapp.domain.event_statistics

import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class EventStatisticsInteractor @Inject constructor(private val eventStatisticsRepository: EventStatisticsRepository) {

    suspend fun getEventStatistics(id: Int): ResultState<EventStatisticsModel> {
        return eventStatisticsRepository.getEventStatistics(id)
    }


}

