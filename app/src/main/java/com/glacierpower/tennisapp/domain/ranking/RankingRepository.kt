package com.glacierpower.tennisapp.domain.ranking

import com.glacierpower.tennisapp.model.rankingModel.RankingModel
import com.glacierpower.tennisapp.utils.ResultState

interface RankingRepository {

    suspend fun getAtpRanking(): ResultState<List<RankingModel>>

    suspend fun getWtaRanking(): ResultState<List<RankingModel>>


}