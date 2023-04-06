package com.glacierpower.tennisapp.data.service

import com.glacierpower.tennisapp.data.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TennisApiService {

    @GET("api/tennis/search/")
    suspend fun searchPlayer(
        @Path("name")
        name: String
    ): Single<SearchResponse>
}