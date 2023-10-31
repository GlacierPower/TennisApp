package com.glacierpower.tennisapp.data.service

import com.glacierpower.tennisapp.data.service.responce.PlayerLastEventsResponse
import com.glacierpower.tennisapp.data.service.responce.RankingResponse
import com.glacierpower.tennisapp.data.service.responce.SearchResponse
import com.glacierpower.tennisapp.data.service.responce.event_details.EventDetailsResponse
import com.glacierpower.tennisapp.data.service.responce.live_event.LiveEventsResponse
import com.glacierpower.tennisapp.data.service.responce.player_details.DetailsResponse
import com.glacierpower.tennisapp.data.service.responce.player_near_events.PlayerNearEventsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TennisApiService {

    @GET("rankings/atp")
    suspend fun getAtpRanking(): Response<RankingResponse>

    @GET("rankings/wta")
    suspend fun getWtaRanking(): Response<RankingResponse>

    @GET("search/{value}")
    suspend fun search(@Path("value") value: String): Response<SearchResponse>

    @GET("events/live")
    suspend fun getLiveEvents(): Response<LiveEventsResponse>

    @GET("team/{id}")
    suspend fun getPlayerDetails(@Path("id") id: Int): Response<DetailsResponse>

    @GET("team/{id}/events/near")
    suspend fun getPlayerNearEvents(@Path("id") id: Int): Response<PlayerNearEventsResponse>

    @GET("team/{id}/events/previous/0")
    suspend fun getPlayerLastEvents(@Path("id") id: Int): Response<PlayerLastEventsResponse>

    @GET("event/{id}")
    suspend fun getEventDetails(@Path("id") id: Int):Response<EventDetailsResponse>

}