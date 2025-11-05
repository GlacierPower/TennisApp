package model.common

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class SportModel(
    val id: Int,
    val slug: String,
    val name: String,
    val nameTranslations: NameTranslationsModel?
)
