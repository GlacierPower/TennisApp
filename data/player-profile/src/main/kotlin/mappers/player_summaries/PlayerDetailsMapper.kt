package mappers.player_summaries

import api.responce.player_details.DetailsRs
import mappers.toManagerModel
import mappers.toNameTranslationsModel
import mappers.toSectionModel
import mappers.toSportModel
import mappers.toVenueModel
import models.player_details.details.PlayerDetailsModel

fun DetailsRs.toPlayerDetailsModel(): PlayerDetailsModel {
    return PlayerDetailsModel(
        id = id,
        sportId = sportId,
        categoryId = categoryId,
        venueId = venueId,
        managerId = managerId,
        slug = slug,
        name = name,
        hasLogo = hasLogo,
        logo = logo,
        nameTranslations = nameTranslations.toNameTranslationsModel(),
        nameShort = nameShort,
        nameFull = nameFull,
        nameCode = nameCode,
        hasSub = hasSub,
        gender = gender,
        isNationality = isNationality,
        countryCode = countryCode,
        country = country,
        flag = flag,
        foundation = foundation,
        details = details?.toPlayerDetailModel(),
        sport = sport.toSportModel(),
        section = section?.toSectionModel(),
        venue = venue?.toVenueModel(),
        manager = manager?.toManagerModel(),
        tennisRanking = tennisRanking?.toTennisRankingModel()
    )
}
