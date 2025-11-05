package api.responce.point_by_point

data class GameDataRs(
    val game: Int,
    val points: List<PointDataRs>,
    val score: ScoreDataRs
)
