package com.glacirepower.tennisapp.match_details.mappers

import api.responce.point_by_point.PointDataRs
import com.glacirepower.tennisapp.match_details.model.PointDataModel

fun List<PointDataRs>.toPointDataModel(): List<PointDataModel> {
    return this.map { pointDataRs ->
        PointDataModel(
            homePoint = pointDataRs.homePoint,
            awayPoint = pointDataRs.awayPoint,
            pointDescription = pointDataRs.pointDescription,
            homePointType = pointDataRs.homePointType,
            awayPointType = pointDataRs.awayPointType
        )
    }
}
