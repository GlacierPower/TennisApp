package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class MainStatModel(
    val aces: StatModel?,
    val doubleFaults: StatModel?,
    val firstServe: StatModel?,
    val secondServe: StatModel?
)
