package model.events

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import model.common.NameTranslationsModel

@Serializable
@InternalSerializationApi
data class ChallengeModel(
    val id: Int,
    val sportId: Int,
    val leagueId: Int,
    val slug: String,
    val name: String,
    val nameTranslationsRs: NameTranslationsModel,
    val order: Int,
    val priority: Int,
)
