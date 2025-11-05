package com.glacierpower.tennisapp

import android.app.Application
import android.content.res.Configuration
import com.lokalise.sdk.Lokalise
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Lokalise.init(
            appContext = this,
            sdkToken = BuildConfig.SDK_TOCKEN,
            projectId = BuildConfig.PROJECT_ID
        )
        Lokalise.updateTranslations()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Lokalise.updateTranslations()
    }
}
