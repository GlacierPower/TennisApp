package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class OutcomeModel(
    val value: Double?,
    val change: Int?
)
