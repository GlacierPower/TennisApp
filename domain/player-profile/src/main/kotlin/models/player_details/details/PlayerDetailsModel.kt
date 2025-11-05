package models.player_details.details

import model.common.ManagerModel
import model.common.NameTranslationsModel
import model.common.SectionModel
import model.common.SportModel
import model.common.VenueModel

data class PlayerDetailsModel(
    val id: Int,
    val sportId: Int,
    val categoryId: Int?,
    val venueId: Int?,
    val managerId: Int?,
    val slug: String,
    val name: String,
    val hasLogo: Boolean,
    val logo: String,
    val nameTranslations: NameTranslationsModel,
    val nameShort: String,
    val nameFull: String,
    val nameCode: String,
    val hasSub: Boolean,
    val gender: String,
    val isNationality: Boolean,
    val countryCode: String,
    val country: String,
    val flag: String,
    val foundation: String?,
    val details: PlayerDetailModel?,
    val sport: SportModel,
    val section: SectionModel?,
    val venue: VenueModel?,
    val manager: ManagerModel?,
    val tennisRanking: TennisRankingModel?
)
