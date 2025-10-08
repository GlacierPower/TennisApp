package com.glacirepower.tennisapp.match_details.mappers

import api.responce.point_by_point.PointByPointRs
import com.glacirepower.tennisapp.match_details.model.PointByPontModel

fun PointByPointRs.toPointByPointModel(): PointByPontModel {
    return PointByPontModel(
        data = data.toMatchDataModel(),
        meta = meta
    )
}
