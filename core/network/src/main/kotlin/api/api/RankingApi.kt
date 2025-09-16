
package api.api

import api.responce.ranking.RankingResponse
import model.ApiResult
import retrofit2.http.GET

interface RankingApi {

    @GET("tennis-rankings/atp?page=1")
    suspend fun getRanking(): ApiResult<RankingResponse>
}
