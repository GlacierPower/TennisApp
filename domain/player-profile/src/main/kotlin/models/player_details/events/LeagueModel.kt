package models.player_details.events

import model.common.NameTranslationsModel

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
