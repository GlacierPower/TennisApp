package api.api

import api.responce.PlayerLastEventsResponse
import api.responce.SearchResponse
import api.responce.event_details.EventDetailsResponse
import api.responce.live_event.LiveEventsResponse
import api.responce.player_details.DetailsResponse
import api.responce.player_near_events.PlayerNearEventsResponse
import api.responce.ranking.RankingResponse
import model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface TennisApi {

    @GET("rankings.json")
    suspend fun getRanking(): ApiResult<RankingResponse>

    @GET("search/{value}")
    suspend fun search(@Path("value") value: String): ApiResult<SearchResponse>

    @GET("events/live")
    suspend fun getLiveEvents(): ApiResult<LiveEventsResponse>

    @GET("team/{id}")
    suspend fun getPlayerDetails(@Path("id") id: Int): ApiResult<DetailsResponse>

    @GET("team/{id}/events/near")
    suspend fun getPlayerNearEvents(@Path("id") id: Int): ApiResult<PlayerNearEventsResponse>

    @GET("team/{id}/events/previous/0")
    suspend fun getPlayerLastEvents(@Path("id") id: Int): ApiResult<PlayerLastEventsResponse>

    @GET("event/{id}")
    suspend fun getEventDetails(@Path("id") id: Int): ApiResult<EventDetailsResponse>
}