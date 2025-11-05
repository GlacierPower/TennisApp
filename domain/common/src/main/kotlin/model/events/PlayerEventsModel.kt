package model.events

import kotlinx.serialization.InternalSerializationApi

@InternalSerializationApi
data class PlayerEventsModel(
    val data: List<PlayerEventsDataModel>,
    val meta: MetaModel
)
