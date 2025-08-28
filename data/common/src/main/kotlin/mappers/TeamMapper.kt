package mappers

import api.responce.common.Team
import model.TeamModel

fun Team.toTeamModel(): TeamModel {
    return TeamModel(
        name = name,
        slug = slug,
        shortName = shortName,
        gender = gender,
        sport = sport.toSportModel(),
        userCount = userCount,
        nameCode = nameCode,
        ranking = ranking,
        disabled = disabled,
        national = national,
        type = type,
        id = id,
        country = country.toCountryModel(),
        teamColor = teamColor.toTeamColorModel(),
        fieldTranslationsModel = fieldTranslations.toFieldTranslationModel()
    )
}