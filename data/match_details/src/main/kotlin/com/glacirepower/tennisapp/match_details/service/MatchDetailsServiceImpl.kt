package com.glacirepower.tennisapp.match_details.service

import api.api.EventApi
import com.glacirepower.tennisapp.match_details.mappers.point_by_point.toPointByPointModel
import com.glacirepower.tennisapp.match_details.mappers.statistics.toStatisticsModel
import com.glacirepower.tennisapp.match_details.model.PointByPontModel
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class MatchDetailsServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val eventApi: EventApi
) : MatchDetailsService {
    override suspend fun getEventPointByPoint(id: String): TennisResult<PointByPontModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                eventApi.getScorePointByPoint(id)
            },
            mapper = { pointByPointRs ->
                pointByPointRs.toPointByPointModel()
            }
        )
    }

    override suspend fun getEventStatistics(id: String): TennisResult<StatisticsModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                eventApi.getEventStatistics(id)
            },
            mapper = { statisticsRs ->
                statisticsRs.toStatisticsModel()
            }
        )
    }
}
