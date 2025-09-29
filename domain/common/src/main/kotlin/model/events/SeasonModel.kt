package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class SeasonModel(
    val id: Int,
    val leagueId: Int,
    val slug: String,
    val name: String,
    val yearStart: Int,
    val yearEnd: Int?
)
