
package service

import com.glacierpower.tennisapp.domain.ranking.models.RankingModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface RankingService {

    suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError>
}
