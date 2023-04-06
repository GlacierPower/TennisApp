package com.glacierpower.tennisapp.di.component

import com.glacierpower.tennisapp.MainActivity
import com.glacierpower.tennisapp.di.AppModule
import com.glacierpower.tennisapp.di.DataBaseModule
import com.glacierpower.tennisapp.di.DataModule
import com.glacierpower.tennisapp.di.DomainModule
import com.glacierpower.tennisapp.di.factory.ScreenScope
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        DataModule::class,
        DomainModule::class
    ]
)

@ScreenScope
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}