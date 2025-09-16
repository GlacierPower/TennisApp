
package service

import android.util.Log
import api.api.RankingApi
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import mappers.toRankingsModel
import model.ApiResult
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class RankingServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val rankingApi: RankingApi
) : RankingService {

    override suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError> {
        try {
            val result = rankingApi.getRanking()
            Log.d("✅ API call successful", "$result rankings")
            ApiResult.Success(result)
        } catch (e: Exception) {
            Log.e(e.message, "API call failed")
            ApiResult.Error(
                message = e.message ?: "",
                httpCode = 1,
                codes = listOf(e.message ?: "")
            )
        }
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                rankingApi.getRanking()
            },
            mapper = { rankingRs ->
                rankingRs.data.toRankingsModel()
            }
        )
    }
}
