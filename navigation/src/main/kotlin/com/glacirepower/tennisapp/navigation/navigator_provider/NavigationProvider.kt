package com.glacirepower.tennisapp.navigation.navigator_provider

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey

internal interface NavigationProvider {
    fun provideEntry(key: NavKey): NavEntry<NavKey>
}
