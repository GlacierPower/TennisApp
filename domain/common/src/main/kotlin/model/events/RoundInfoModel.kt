package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class RoundInfoModel(
    val round: Int,
    val name: String?,
    val cupRoundType: Int?
)
