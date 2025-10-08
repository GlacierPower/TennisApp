package com.glacirepower.tennisapp.match_details.repository

import com.glacirepower.tennisapp.match_details.model.PointByPontModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface MatchDetailsRepository {
    suspend fun getEventPointByPoint(id: String): TennisResult<PointByPontModel, DataError.NetworkError>
}
