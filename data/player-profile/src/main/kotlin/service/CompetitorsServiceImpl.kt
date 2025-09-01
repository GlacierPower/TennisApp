package service

import android.util.Log
import api.api.CompetitorsApi
import mappers.toPlayerProfileModel
import model.ApiResult
import models.PlayerProfileModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class CompetitorsServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val competitorsApi: CompetitorsApi
) : CompetitorsService {
    override suspend fun getPlayerProfile(id: String): TennisResult<PlayerProfileModel, DataError.NetworkError> {
        try {
            val result = competitorsApi.getPlayerProfile(id)
            Log.d("✅ API call successful", "$result rankings")
            ApiResult.Success(result)
        } catch (e: Exception) {
            Log.e(e.message, "API call failed")
            ApiResult.Error(
                message = e.message?:"",
                httpCode = 1,
                codes = listOf(e.message?:"")
            )
        }
        return networkHelper.fetchToTennisResult(
            apiCall = suspend { competitorsApi.getPlayerProfile(id) },
            mapper = { profileRs ->
                profileRs.toPlayerProfileModel()
            }
        )
    }
}