package com.glacirepower.tennisapp.match_details.mappers.point_by_point

import api.responce.point_by_point.PointByPointRs
import com.glacirepower.tennisapp.match_details.model.PointByPontModel

fun PointByPointRs.toPointByPointModel(): PointByPontModel {
    return PointByPontModel(
        data = data.toMatchDataModel(),
        meta = meta
    )
}
