package com.glacirepower.tennisapp.navigation.screens

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface ScreensKey : NavKey {

    @Serializable
    data class PlayerProfile(val id: String?, val rank: String) : ScreensKey
}
