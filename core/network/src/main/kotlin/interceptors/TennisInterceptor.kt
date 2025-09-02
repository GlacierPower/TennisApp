
package interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TennisInterceptor @Inject constructor() : Interceptor {

    private val sportRadarHeader = "accept"
    private val sportRadarType = "application/json"
    private val sportRadar = "x-api-key"
    private val key = "XB8apxPZtyNDebBaHcGx2in4EFFQ9NaJudqXegdY"
    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        originalRequest = originalRequest.newBuilder()
            .header(
                name = sportRadarHeader,
                value = sportRadarType
            )
            .header(sportRadar, key)
            .build()
        return chain.proceed(originalRequest)
    }
}
