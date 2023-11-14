package com.glacierpower.tennisapp.data.repositoryImpl

import android.util.Log
import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.event_statistics.EventStatisticsRepository
import com.glacierpower.tennisapp.model.event_statistics_model.EventStatisticsModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class EventStatisticsRepositoryImpl @Inject constructor(
    @Named("Tennis") private val tennisApiService: TennisApiService
) : EventStatisticsRepository {
    override suspend fun getEventStatistics(id: Int): ResultState<EventStatisticsModel> {
        val response = tennisApiService.getEventStatistics(id)
        return withContext(Dispatchers.IO) {
            ResultState.Success(response.body()!!.toEntity())
        }

    }
}