package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import model.common.NameTranslationsModel

@Serializable
@InternalSerializationApi
data class LeagueModel(
    val id: Int,
    val sportId: Int,
    val sectionId: Int,
    val slug: String,
    val name: String,
    val nameTranslationsRs: NameTranslationsModel,
    val hasLogo: Boolean,
    val logo: String,
)
