package com.glacirepower.tennisapp.match_details.navigation

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import model.events.PlayerEventsDataModel

@Serializable
@InternalSerializationApi
data class MatchDetailsArgs(
    val event: PlayerEventsDataModel?
)
