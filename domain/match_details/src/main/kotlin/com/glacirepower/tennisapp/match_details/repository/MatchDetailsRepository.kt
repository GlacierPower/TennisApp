package com.glacirepower.tennisapp.match_details.repository

import com.glacirepower.tennisapp.match_details.model.PointByPontModel
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface MatchDetailsRepository {
    suspend fun getEventPointByPoint(id: String): TennisResult<PointByPontModel, DataError.NetworkError>

    suspend fun getEventStatistics(id: String): TennisResult<StatisticsModel, DataError.NetworkError>
}
