package com.glacierpower.tennisapp.data.service

import com.glacierpower.tennisapp.data.service.responce.Events.LiveEventsResponse
import com.glacierpower.tennisapp.data.service.responce.RankingResponse
import com.glacierpower.tennisapp.data.service.responce.SearchResponse
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
    suspend fun getLiveEvents():Response<LiveEventsResponse>
}