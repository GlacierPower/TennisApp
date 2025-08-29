package service

import api.api.TennisApi
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import mappers.toRankingModel
import networkHelper.NetworkHelper
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import javax.inject.Inject

class RankingServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val tennisApi: TennisApi
) : RankingService {

    override suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError> = networkHelper.fetchToTennisResult(
            apiCall = suspend {
                tennisApi.getRanking()
            },
            mapper = { rankingRs ->
                rankingRs.rankings.map { it.toRankingModel() }
            }
        )

}