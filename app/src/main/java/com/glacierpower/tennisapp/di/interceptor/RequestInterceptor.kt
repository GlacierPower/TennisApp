package com.glacierpower.tennisapp.di.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-key", "445ccae8f6msh2cbf90cd04031d2p1ab8a8jsn2baf87fbd252")
            .addHeader("x-rapidapi-host", "tennisapi1.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}