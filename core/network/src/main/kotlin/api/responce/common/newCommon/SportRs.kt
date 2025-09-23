package api.responce.common.newCommon

import com.squareup.moshi.Json

data class SportRs(
    val id: Int,
    val slug: String,
    val name: String,
    @property:Json(name = "name_translations")
    val nameTranslations: NameTranslationsRs?
)
