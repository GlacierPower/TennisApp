package api.api

import api.responce.player_details.PlayerDetailsRs
import api.responce.ranking.RankingRs
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface RankingApi {

    @GET("tennis-rankings/atp?page=1")
    suspend fun getRanking(): ApiResult<RankingRs>

    @GET("teams/{id}")
    suspend fun getPlayerDetails(
        @Path("id") id: String
    ): ApiResult<PlayerDetailsRs>
}
