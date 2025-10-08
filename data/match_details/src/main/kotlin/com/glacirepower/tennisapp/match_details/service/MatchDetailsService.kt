package com.glacirepower.tennisapp.match_details.service

import com.glacirepower.tennisapp.match_details.model.PointByPontModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface MatchDetailsService {

    suspend fun getEventPointByPoint(id: String): TennisResult<PointByPontModel, DataError.NetworkError>
}
