
package networkHelper

import model.ApiResult
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface NetworkHelper {

    suspend fun <I : Any, O> fetchToTennisResult(
        mapper: (I) -> O,
        apiCall: suspend () -> ApiResult<I>
    ): TennisResult<O, DataError.NetworkError>

    suspend fun <I : Any> fetchToTennisResult(
        apiCall: suspend () -> ApiResult<I>
    ): TennisResult<Unit, DataError.NetworkError>
}
