package api.responce.common

import com.squareup.moshi.Json

data class ManagerRs(
    val id: Int,
    @property:Json(name = "sport_id") val sportId: Int,
    val slug: String,
    val name: String,
    @property:Json(name = "name_translations")
    val nameTranslations: Map<String, String>,
    @property:Json(name = "name_short")
    val nameShort: String,
    @property:Json(name = "has_photo")
    val hasPhoto: Boolean,
    val photo: String,
    @property:Json(name = "date_birth")
    val dateBirth: String?,
    @property:Json(name = "nationality_code")
    val nationalityCode: String,
    val performance: PerformanceRs,
    @property:Json(name = "preferred_formation")
    val preferredFormation: String
)
