package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class MainOddsModel(
    val outcome1: OutcomeModel,
    val outcome2: OutcomeModel
)
