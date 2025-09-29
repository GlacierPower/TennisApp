package api.api

import api.responce.country_flags.CountryFlagsRs
import model.ApiResult
import retrofit2.http.GET

interface CountryFlagApi {
    @GET("allcountryflags")
    suspend fun getCountryFlags(): ApiResult<List<CountryFlagsRs>>
}
