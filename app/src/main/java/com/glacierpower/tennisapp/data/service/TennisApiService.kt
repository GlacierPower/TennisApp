package com.glacierpower.tennisapp.data.service

import com.glacierpower.tennisapp.data.service.responce.RankingResponse
import retrofit2.Response
import retrofit2.http.GET

interface TennisApiService {

    @GET("rankings/atp")
    suspend fun getAtpRanking(): Response<RankingResponse>

    @GET("rankings/wta")
    suspend fun getWtaRanking(): Response<RankingResponse>

}