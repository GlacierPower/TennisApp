
package model

import kotlinx.serialization.json.Json
import retrofit2.HttpException
import retrofit2.Response
import java.lang.reflect.Type

sealed interface ApiResult<T : Any?> {
    data class Success<T : Any>(val data: T) : ApiResult<T>
    data class Error<T : Any>(val httpCode: Int, val codes: List<String>?, val message: String) :
        ApiResult<T>

    data class ApiException<T : Any>(val throwable: Throwable) : ApiResult<T> {
        override fun toString(): String {
            return "ApiException: ${throwable.message}"
        }
    }
}

internal inline fun <T : Any> handleApi(
    json: Json,
    resultType: Type,
    execute: () -> Response<T>
): ApiResult<T> {
    return try {
        val response = execute()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                ApiResult.Success(body)
            } else if (resultType == Unit::class.java) {
                @Suppress("UNCHECKED_CAST")
                ApiResult.Success(Unit as T)
            } else {
                ApiResult.Error(
                    httpCode = response.code(),
                    codes = listOf(),
                    message = "Response body is null"
                )
            }
        } else {
            ApiResult.Error(
                httpCode = response.code(),
                codes = listOf(),
                message = response.message()
            )
        }
    } catch (e: HttpException) {
        ApiResult.Error(httpCode = e.code(), codes = null, message = e.message())
    } catch (e: Exception) {
        ApiResult.ApiException(e)
    }
}
