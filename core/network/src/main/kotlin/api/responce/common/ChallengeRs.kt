package api.responce.common

import com.squareup.moshi.Json

data class ChallengeRs(
    val id: Int,
    @property:Json("sport_id")
    val sportId: Int,
    @property:Json("league_id")
    val leagueId: Int,
    val slug: String,
    val name: String,
    @property:Json("name_translations")
    val nameTranslationsRs: NameTranslationsRs,
    val order: Int,
    val priority: Int,
)
