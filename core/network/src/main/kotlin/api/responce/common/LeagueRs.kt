package api.responce.common

import com.squareup.moshi.Json

data class LeagueRs(
    val id: Int,
    @property:Json("sport_id")
    val sportId: Int,
    @property:Json("section_id")
    val sectionId: Int,
    val slug: String,
    val name: String,
    @property:Json("name_translations")
    val nameTranslationsRs: NameTranslationsRs,
    @property:Json("has_logo")
    val hasLogo: Boolean,
    val logo: String,
)
