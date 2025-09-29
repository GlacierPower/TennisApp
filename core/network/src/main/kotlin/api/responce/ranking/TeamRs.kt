package api.responce.ranking

import api.responce.common.newCommon.NameTranslationsRs
import com.squareup.moshi.Json

data class TeamRs(
    val id: Int,
    @property:Json(name = "sport_id")
    val sportId: Int,
    @property:Json(name = "category_id")
    val categoryId: Int?,
    @property:Json(name = "venue_id")
    val venueId: Int?,
    @property:Json(name = "manager_id")
    val managerId: Int?,
    val slug: String,
    val name: String,
    @property:Json(name = "has_logo")
    val hasLogo: Boolean,
    val logo: String,
    @property:Json(name = "name_translations")
    val nameTranslationsRs: NameTranslationsRs,
    @property:Json(name = "name_short")
    val nameShort: String,
    @property:Json(name = "name_full")
    val nameFull: String,
    @property:Json(name = "name_code")
    val nameCode: String,
    @property:Json(name = "has_sub")
    val hasSub: Boolean,
    val gender: String,
    @property:Json(name = "is_nationality")
    val isNationality: Boolean,
    @property:Json(name = "country_code")
    val countryCode: String,
    val country: String,
    val flag: String,
    val foundation: String?
)
