package di

import android.content.Context
import call_adapter.ApiResultCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import interceptors.TennisInterceptor
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import qualifiers.Tennis
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object TennisModule {
    @Provides
    @Singleton
    @Tennis
    fun provideTennisOkHttpClient(
        tennisInterceptor: TennisInterceptor,
        context: Context
    ): OkHttpClient {
        val httpCacheDirectory = File(context.cacheDir, "http-cache")
        val cacheSize: Long = 10 * 1024 * 1024
        val cache = Cache(httpCacheDirectory, cacheSize)
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(tennisInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    @Tennis
    fun provideTennisRetrofitClient(
        @Tennis
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        val baseUrl = "https://api.sportradar.com/tennis/trial/v3/en/"
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ApiResultCallAdapterFactory.create(json))
            .build()
        return retrofit
    }
}