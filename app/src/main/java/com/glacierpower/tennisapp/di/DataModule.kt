package com.glacierpower.tennisapp.di

import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.di.interceptor.RequestInterceptor
import com.glacierpower.tennisapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class DataModule {
    companion object {

        @Provides
        fun provideTennisApi(retrofit: Retrofit): TennisApiService =
            retrofit.create(TennisApiService::class.java)


        @Provides
        fun provideOkHttpClient(): OkHttpClient {
            val client = OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
            return client.build()
        }

        @Provides
        fun provideRetrofit(
            client: OkHttpClient
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

        }
    }
}