package api.api

import api.responce.player_events.PlayerEventsRs
import api.responce.point_by_point.PointByPointRs
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface EventApi {
    @GET("teams/{id}/events?page=1")
    suspend fun getPlayerEvents(
        @Path("id") id: String
    ): ApiResult<PlayerEventsRs>

    @GET("/events/{id}/points")
    suspend fun getScorePointByPoint(
        @Path("id") id: String
    ): ApiResult<PointByPointRs>
}
