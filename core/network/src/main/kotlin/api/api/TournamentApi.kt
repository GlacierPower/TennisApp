package api.api

import api.responce.tournament_details.TournamentRs
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface TournamentApi {
    @GET("leagues/{id}/events?page=4")
    suspend fun getTournamentDetails(
        @Path("id") id: String
    ): ApiResult<TournamentRs>
}
