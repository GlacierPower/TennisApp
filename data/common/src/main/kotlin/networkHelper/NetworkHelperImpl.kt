
package networkHelper

import model.ApiResult
import network.tennisResult.DataError
import network.tennisResult.DataError.NetworkError.BadRequest
import network.tennisResult.DataError.NetworkError.Conflict
import network.tennisResult.DataError.NetworkError.DataNotFound
import network.tennisResult.DataError.NetworkError.Forbidden
import network.tennisResult.DataError.NetworkError.IncorrectFormat
import network.tennisResult.DataError.NetworkError.ServiceUnavailable
import network.tennisResult.DataError.NetworkError.Unauthorized
import network.tennisResult.DataError.NetworkError.Unknown
import network.tennisResult.TennisResult
import network.tennisResult.TennisResult.Error
import network.tennisResult.TennisResult.Success
import javax.inject.Inject

class NetworkHelperImpl @Inject constructor() : NetworkHelper {
    override suspend fun <I : Any, O> fetchToTennisResult(
        mapper: (I) -> O,
        apiCall: suspend () -> ApiResult<I>
    ): TennisResult<O, DataError.NetworkError> {
        return when (val result = apiCall()) {
            is ApiResult.Success -> {
                Success(mapper(result.data))
            }

            is ApiResult.Error -> {
                val errorResult = when (result.httpCode) {
                    400 -> BadRequest(
                        errorCodes = result.codes,
                        detailedMessage = result.message
                    )

                    401 -> Unauthorized(result.codes)
                    403 -> Forbidden(result.codes)
                    404 -> DataNotFound(result.codes)
                    409 -> Conflict(result.codes)
                    415 -> IncorrectFormat(result.codes)
                    503 -> ServiceUnavailable(result.codes)
                    else -> Unknown
                }
                Error(errorResult)
            }

            is ApiResult.ApiException -> {
                Error(Unknown)
            }
        }
    }

    override suspend fun <I : Any> fetchToTennisResult(
        apiCall: suspend () -> ApiResult<I>
    ): TennisResult<Unit, DataError.NetworkError> =
        fetchToTennisResult(mapper = {}, apiCall = apiCall)
}
