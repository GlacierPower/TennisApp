package com.glacierpower.tennisapp

import android.app.Application
import android.content.res.Configuration
import com.lokalise.sdk.Lokalise
import dagger.hilt.android.HiltAndroidApp
import repository.LoggerRepository
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var logger: LoggerRepository

    override fun onCreate() {
        super.onCreate()
        Lokalise.init(
            appContext = this,
            sdkToken = BuildConfig.SDK_TOCKEN,
            projectId = BuildConfig.PROJECT_ID
        )
        Lokalise.updateTranslations()

        setupExceptionHandler(logger)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Lokalise.updateTranslations()
    }

    private fun setupExceptionHandler(logger: LoggerRepository) {
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            logger.error("Crash", "App crashed in thread: ${thread.name}", throwable)
            //  save logs or send to server ??
            Thread.getDefaultUncaughtExceptionHandler()?.uncaughtException(thread, throwable)
        }
    }
}
