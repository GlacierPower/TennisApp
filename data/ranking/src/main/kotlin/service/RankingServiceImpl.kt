
package service

import api.api.CountryFlagApi
import api.api.RankingApi
import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import mappers.country_flags.toCountryFlagsModel
import mappers.toRankingsModel
import model.common.CountryFlagsModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class RankingServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val rankingApi: RankingApi,
    private val countryFlagApi: CountryFlagApi
) : RankingService {

    override suspend fun getRanking(): TennisResult<List<RankingModel>, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                rankingApi.getRanking()
            },
            mapper = { rankingRs ->
                rankingRs.data.toRankingsModel()
            }
        )
    }

    override suspend fun getCountryFlags(): TennisResult<List<CountryFlagsModel>, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend {
                countryFlagApi.getCountryFlags()
            },
            mapper = { countryFlagRs ->
                countryFlagRs.toCountryFlagsModel()
            }
        )
    }
}
