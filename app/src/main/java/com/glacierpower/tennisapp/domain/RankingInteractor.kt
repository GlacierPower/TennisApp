package com.glacierpower.tennisapp.domain

import com.glacierpower.tennisapp.model.RankingModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class RankingInteractor @Inject constructor(
    private val rankingRepository: RankingRepository
) {

    suspend fun getAtpRanking(): ResultState<List<RankingModel>> {
        return rankingRepository.getAtpRanking()
    }

    suspend fun getWtaRanking(): ResultState<List<RankingModel>> {
        return rankingRepository.getWtaRanking()
    }
}