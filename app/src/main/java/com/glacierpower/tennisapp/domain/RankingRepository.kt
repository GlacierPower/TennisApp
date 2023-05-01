package com.glacierpower.tennisapp.domain

import com.glacierpower.tennisapp.model.RankingModel
import com.glacierpower.tennisapp.utils.ResultState

interface RankingRepository {

    suspend fun getAtpRanking(): ResultState<List<RankingModel>>
}