package com.glacierpower.tennisapp.data.repositoryImpl

import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.RankingRepository
import com.glacierpower.tennisapp.model.RankingModel
import com.glacierpower.tennisapp.utils.NetworkUtils.executeNonBlocking
import com.glacierpower.tennisapp.utils.ResultState
import com.glacierpower.tennisapp.utils.Success
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val tennisApiService: TennisApiService
) : RankingRepository {
    override suspend fun getAtpRanking(): ResultState<List<RankingModel>> {
        return executeNonBlocking {
            val responce = tennisApiService.getAtpRanking()
            Success(responce.body()?.rankings.let { list ->
                list!!.map { rankings ->
                    rankings.toEntity()
                }
            })
        }

    }

}