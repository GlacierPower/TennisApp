package com.glacirepower.tennisapp.navigation.navigator_provider

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey

internal class CompositeNavigationProvider(
    private val providers: List<NavigationProvider>
) : NavigationProvider {
    override fun provideEntry(key: NavKey): NavEntry<NavKey> {
        providers.forEach { provider ->
            try {
                return provider.provideEntry(key)
            } catch (e: Exception) {
                error("No navigation provider found for key: $e")
            }
        }
        error("No navigation provider found for key: $key")
    }
}
