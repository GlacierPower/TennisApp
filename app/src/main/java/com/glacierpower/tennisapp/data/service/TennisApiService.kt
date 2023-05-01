package com.glacierpower.tennisapp.data.service

import com.glacierpower.tennisapp.data.service.responce.RankingResponce
import retrofit2.Response
import retrofit2.http.GET

interface TennisApiService {

    @GET("rankings/atp")
    suspend fun getAtpRanking(): Response<RankingResponce>

}