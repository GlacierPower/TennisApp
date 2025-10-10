package com.glacirepower.tennisapp.match_details.repository

import com.glacirepower.tennisapp.match_details.model.PointByPontModel
import com.glacirepower.tennisapp.match_details.model.statistics.StatisticsModel
import com.glacirepower.tennisapp.match_details.service.MatchDetailsService
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import javax.inject.Inject

class MatchDetailsRepositoryImpl @Inject constructor(
    private val matchDetailsService: MatchDetailsService
) : MatchDetailsRepository {
    override suspend fun getEventPointByPoint(id: String): TennisResult<PointByPontModel, DataError.NetworkError> =
        matchDetailsService.getEventPointByPoint(id)

    override suspend fun getEventStatistics(id: String): TennisResult<StatisticsModel, DataError.NetworkError> =
        matchDetailsService.getEventStatistics(id)
}
