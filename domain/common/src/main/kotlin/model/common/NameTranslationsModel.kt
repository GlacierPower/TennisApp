package model.common

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
@InternalSerializationApi
data class NameTranslationsModel(
    val en: String?,
    val ru: String?,
    val es: String?,
    val fr: String?,
    val zh: String?,
    val pt: String?,
    val el: String?,
    val it: String?
)
