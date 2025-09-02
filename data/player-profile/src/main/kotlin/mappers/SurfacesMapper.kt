
package mappers

import api.responce.player_profile.Surfaces
import models.SurfacesModel

fun List<Surfaces>.toSurfacesModel(): List<SurfacesModel> {
    return this.map { surface ->
        SurfacesModel(
            type = surface.type,
            statistics = surface.statistics.toStatisticsModel()
        )
    }
}
