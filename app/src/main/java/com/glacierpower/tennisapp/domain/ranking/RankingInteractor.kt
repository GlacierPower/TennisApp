package com.glacierpower.tennisapp.domain.ranking

import com.glacierpower.tennisapp.model.rankingModel.RankingModel
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