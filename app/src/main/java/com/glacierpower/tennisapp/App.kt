package com.glacierpower.tennisapp

import android.app.Application
import com.glacierpower.tennisapp.di.AppModule
import com.glacierpower.tennisapp.di.component.AppComponent
import com.glacierpower.tennisapp.di.component.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    fun provideAppComponent(): AppComponent {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}