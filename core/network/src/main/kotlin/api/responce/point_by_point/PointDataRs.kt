package api.responce.point_by_point

data class PointDataRs(
    val homePoint: String,
    val awayPoint: String,
    val pointDescription: Int,
    val homePointType: Int,
    val awayPointType: Int
)
