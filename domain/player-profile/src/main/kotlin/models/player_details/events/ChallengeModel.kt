package models.player_details.events

import model.common.NameTranslationsModel

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
