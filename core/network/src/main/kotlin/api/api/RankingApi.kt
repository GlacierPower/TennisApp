
package api.api

import api.responce.ranking.RankingResponse
import model.ApiResult
import retrofit2.http.GET

interface RankingApi {

    @GET("rankings")
    suspend fun getRanking(): ApiResult<RankingResponse>
}
