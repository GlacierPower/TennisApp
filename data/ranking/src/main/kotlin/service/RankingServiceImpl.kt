
package service

import api.api.RankingApi
import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import mappers.toRankingModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class RankingServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val rankingApi: RankingApi
) : RankingService {

    override suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError> = networkHelper.fetchToTennisResult(
        apiCall = suspend {
            rankingApi.getRanking()
        },
        mapper = { rankingRs ->
            rankingRs.rankings.map { it.toRankingModel() }
        }
    )
}
