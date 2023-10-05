package com.glacierpower.tennisapp.data.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesFlagsApiService {

    @GET("{code}.svg")
    fun getCountryFlag(@Path("code") code: String): retrofit2.Response<ResponseBody>
}