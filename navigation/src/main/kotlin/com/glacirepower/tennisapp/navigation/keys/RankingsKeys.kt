package com.glacirepower.tennisapp.navigation.keys

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface RankingsKeys : NavKey {

    @Serializable
    data class PlayerProfile(val id: String?) : RankingsKeys

    @Serializable
    data class MatchDetails(
        val eventId: String
    ) : RankingsKeys
}
