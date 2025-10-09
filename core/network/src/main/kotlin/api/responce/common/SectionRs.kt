package api.responce.common

import com.squareup.moshi.Json

data class SectionRs(
    val id: Int,
    @property:Json(name = "sport_id")
    val sportId: Int,
    val slug: String,
    val name: String,
    @property:Json(name = "name_translations")
    val nameTranslations: NameTranslationsRs?,
    val priority: Int,
    val flag: String
)
