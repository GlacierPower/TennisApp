package com.glacirepower.tennisapp.navigation.keys

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import model.events.PlayerEventsDataModel

sealed interface RankingsKeys : NavKey {

    @Serializable
    data class PlayerProfile(val id: String?) : RankingsKeys

    @Serializable
    @InternalSerializationApi
    data class MatchDetails(
        val event: PlayerEventsDataModel?
    ) : RankingsKeys

    @Serializable
    data class TournamentDetails(val id: String?) : RankingsKeys
}
