package com.glacierpower.tennisapp.data.repositoryImpl

import android.util.Log
import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.ranking.RankingRepository
import com.glacierpower.tennisapp.model.rankingModel.RankingModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val tennisApiService: TennisApiService,
) : RankingRepository {
    override suspend fun getAtpRanking(): ResultState<List<RankingModel>> {
        val atpResponse = tennisApiService.getAtpRanking()
        return withContext(Dispatchers.IO) {
            ResultState.Success(atpResponse.body()?.rankings.let { list ->
                list!!.map { rankings ->
                    rankings.toEntity()
                }
            })

        }

    }

    override suspend fun getWtaRanking(): ResultState<List<RankingModel>> {
        val wtaResponse = tennisApiService.getWtaRanking()
        return withContext(Dispatchers.IO) {
            ResultState.Success(wtaResponse.body()?.rankings.let { list ->
                list!!.map { rankings ->
                    rankings.toEntity()
                }
            })
        }
    }


}