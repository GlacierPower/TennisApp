
package api.api

import api.responce.ranking.RankingResponse
import model.ApiResult
import retrofit2.http.GET

interface RankingApi {

    @GET("rankings.json")
    suspend fun getRanking(): ApiResult<RankingResponse>
}
