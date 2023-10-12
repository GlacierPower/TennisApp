package com.glacierpower.tennisapp.di

import android.content.Context
import com.glacierpower.tennisapp.data.repositoryImpl.LiveEventRepositoryImpl
import com.glacierpower.tennisapp.data.repositoryImpl.RankingRepositoryImpl
import com.glacierpower.tennisapp.data.repositoryImpl.SearchRepositoryImpl
import com.glacierpower.tennisapp.data.service.CountriesFlagsApiService
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.events.LiveEventsRepository
import com.glacierpower.tennisapp.domain.ranking.RankingRepository
import com.glacierpower.tennisapp.domain.search.SearchRepository
import com.glacierpower.tennisapp.utils.Constants.KEY
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRankingRepository(
        rankingRepositoryImpl: RankingRepositoryImpl
    ): RankingRepository

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    abstract fun bindLiveEventRepository(
        liveEventsRepositoryImpl: LiveEventRepositoryImpl
    ): LiveEventsRepository

    companion object {

        private const val HEADER_KEY_RAPID_API_HOST = "x-rapidapi-host"
        private const val HEADER_VALUE_RAPID_API_HOST = "tennisapi1.p.rapidapi.com"
        private const val HEADER_KEY_RAPID_API_KEY = "x-rapidapi-key"
        private const val BASE_URL = "https://tennisapi1.p.rapidapi.com/api/tennis/"
        private const val COUNTRY_FLAGS_URL = "https://flagcdn.com/"

        @Provides
        fun provideOkhttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            context: Context
        ): OkHttpClient {
            val httpCacheDirectory = File(context.cacheDir, "http-cache")
            val cacheSize: Long = 10 * 1024 * 1024
            val cache = Cache(httpCacheDirectory, cacheSize)

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor { chain ->
                    val originalRequest = chain.request()

                    val newRequestBuilder = originalRequest.newBuilder()
                        .header(HEADER_KEY_RAPID_API_HOST, HEADER_VALUE_RAPID_API_HOST)
                        .header(HEADER_KEY_RAPID_API_KEY, KEY)

                    val newRequest = newRequestBuilder.build()
                    chain.proceed(newRequest)

                }
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .cache(cache)
                .build()
        }

        @Provides
        fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Named("Tennis")
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        @Named("Tennis")
        @Provides
        fun provideTennisApiService(@Named("Tennis") retrofit: Retrofit): TennisApiService {
            return retrofit.create(TennisApiService::class.java)
        }

        @Named("Countries Flags")
        @Provides
        fun provideCountryFlagsRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(COUNTRY_FLAGS_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        @Named("Countries Flags")
        @Provides
        fun provideCountriesFlagsApiService(@Named("Countries Flags") retrofit: Retrofit): CountriesFlagsApiService {
            return retrofit.create(CountriesFlagsApiService::class.java)
        }

    }
}