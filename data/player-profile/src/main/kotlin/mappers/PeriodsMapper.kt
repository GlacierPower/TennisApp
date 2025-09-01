package mappers

import api.responce.player_profile.ProfilePeriods
import models.ProfilePeriodsModel

fun List<ProfilePeriods>.toProfilePeriodsModel(): List<ProfilePeriodsModel>{
    return this.map { periods->
        ProfilePeriodsModel(
            year = periods.year,
            surfaces = periods.surfaces.toSurfacesModel()
        )
    }
}