package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class StatModel(
    val home: Int?,
    val away: Int?
)
