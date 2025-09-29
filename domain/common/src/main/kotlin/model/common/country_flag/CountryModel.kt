@file:OptIn(InternalSerializationApi::class)

package model.common.country_flag

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class CountryModel(
    val name: String,
    val flag: String
)
