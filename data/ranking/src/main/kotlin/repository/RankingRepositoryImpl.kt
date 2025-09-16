
package repository

import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import com.glacierpower.tennisapp.domain.ranking.repository.RankingRepository
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import service.RankingService
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val rankingService: RankingService
) : RankingRepository {
    override suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError> =
        rankingService.getRanking()
}
