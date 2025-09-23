package interceptors

import com.tennisapp.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryFlagsInterceptor @Inject constructor() : Interceptor {
    val header = "X-Api-Key"
    val key = BuildConfig.COUNTRY_FLAG_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        originalRequest = originalRequest.newBuilder()
            .header(header, key)
            .build()
        return chain.proceed(originalRequest)
    }
}
