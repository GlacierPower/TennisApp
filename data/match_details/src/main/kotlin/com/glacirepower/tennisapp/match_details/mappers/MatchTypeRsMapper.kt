package com.glacirepower.tennisapp.match_details.mappers

import api.responce.point_by_point.SetDataRs
import com.glacirepower.tennisapp.match_details.model.SetDataModel

fun List<SetDataRs>.toSetDataModel(): List<SetDataModel> {
    return this.map { setDataRs ->
        SetDataModel(
            set = setDataRs.set,
            games = setDataRs.games.toGameDataModel().reversed()
        )
    }
}
