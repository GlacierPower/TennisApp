package com.glacirepower.tennisapp.match_details.mappers.point_by_point

import api.responce.point_by_point.MatchDataRs
import com.glacirepower.tennisapp.match_details.model.MatchDataModel

fun List<MatchDataRs>.toMatchDataModel(): List<MatchDataModel> {
    return this.map { dataRs ->
        MatchDataModel(
            id = dataRs.id,
            eventId = dataRs.eventId,
            type = dataRs.type.toSetDataModel().reversed()
        )
    }
}
