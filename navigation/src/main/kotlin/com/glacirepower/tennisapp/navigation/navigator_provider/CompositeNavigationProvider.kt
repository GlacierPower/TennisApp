package com.glacirepower.tennisapp.navigation.navigator_provider

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import timber.log.Timber

internal class CompositeNavigationProvider(
    private val providers: List<NavigationProvider>
) : NavigationProvider {
    override fun provideEntry(key: NavKey): NavEntry<NavKey> {
        providers.forEach { provider ->
            try {
                return provider.provideEntry(key)
            } catch (e: Exception) {
                Timber.tag(e.message.orEmpty()).e(e.message.orEmpty())
            }
        }
        error("No navigation provider found for key: $key")
    }
}
