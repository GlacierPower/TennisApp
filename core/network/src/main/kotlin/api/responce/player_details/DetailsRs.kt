package api.responce.player_details

import api.responce.common.newCommon.ManagerRs
import api.responce.common.newCommon.NameTranslationsRs
import api.responce.common.newCommon.SectionRs
import api.responce.common.newCommon.SportRs
import api.responce.common.newCommon.VenueRs
import com.squareup.moshi.Json

data class DetailsRs(
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
    val nameTranslations: NameTranslationsRs,
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
    val foundation: String?,
    val details: DetailRs?,
    val sport: SportRs,
    val section: SectionRs?,
    val venue: VenueRs?,
    val manager: ManagerRs?,
    @property:Json(name = "tennis_ranking")
    val tennisRanking: TennisRankingRs?
)
