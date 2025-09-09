package api.api

import api.responce.player_summaries.Summaries
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface EventApi {

    @GET("sport_events/{eventId}/summary")
    suspend fun getEventDetails(
        @Path("eventId") eventId: String
    ): ApiResult<Summaries>
}
