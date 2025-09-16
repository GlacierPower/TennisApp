package interceptors

import com.tennisapp.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TennisInterceptor @Inject constructor() : Interceptor {

    private val rapidKey = "x-rapidapi-key"
    private val rapidHost = "-rapidapi-host"
    private val rapidHostValue = "sportscore1.p.rapidapi.com"

    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        originalRequest = originalRequest.newBuilder()
            .header(
                name = rapidKey,
                value = BuildConfig.API_KEY
            )
            .header(rapidHost, rapidHostValue)
            .build()
        return chain.proceed(originalRequest)
    }
}
