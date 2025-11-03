package interceptors


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import repository.LoggerRepository
import javax.inject.Inject

class LoggingInterceptor @Inject constructor(
    private val logger: LoggerRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val startTime = System.currentTimeMillis()

        logRequest(request)

        try {
            val response = chain.proceed(request)
            val duration = System.currentTimeMillis() - startTime

            logResponse(response, duration)

            return response
        } catch (e: Exception) {
            logger.error(
                "NETWORK",
                "Request failed: ${request.url} - ${e.message}",
                e
            )
            throw e
        }
    }

    private fun logRequest(request: Request) {
        try {
            val body = request.body?.let { body ->
                val buffer = Buffer()
                body.writeTo(buffer)
                buffer.readUtf8()
            }

            logger.logNetworkRequest(
                url = request.url.toString(),
                method = request.method,
                headers = request.headers.toMap(),
                body = body
            )
        } catch (e: Exception) {
            logger.error("NETWORK", "Failed to log request", e)
        }
    }

    private fun logResponse(response: Response, duration: Long) {
        try {
            val body = response.body?.let { responseBody ->
                val source = responseBody.source()
                source.request(Long.MAX_VALUE)
                val buffer = source.buffer
                buffer.clone().readUtf8()
            }

            logger.logNetworkResponse(
                url = response.request.url.toString(),
                statusCode = response.code,
                headers = response.headers.toMap(),
                body = body,
                duration = duration
            )
        } catch (e: Exception) {
            logger.error("NETWORK", "Failed to log response", e)
        }
    }

    private fun okhttp3.Headers.toMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        for (i in 0 until size) {
            map[name(i)] = value(i)
        }
        return map
    }
}