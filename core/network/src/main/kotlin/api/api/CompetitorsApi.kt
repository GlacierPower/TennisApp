package api.api

import api.responce.player_profile.PlayerProfileResponse
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface CompetitorsApi {

    @GET("competitors/{id}/profile")
    suspend fun getPlayerProfile(
        @Path("id") id: String
    ): ApiResult<PlayerProfileResponse>
}