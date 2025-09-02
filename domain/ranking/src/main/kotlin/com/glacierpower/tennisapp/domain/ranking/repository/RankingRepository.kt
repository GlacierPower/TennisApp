package com.glacierpower.tennisapp.domain.ranking.repository

import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface RankingRepository {

    suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError>
}
