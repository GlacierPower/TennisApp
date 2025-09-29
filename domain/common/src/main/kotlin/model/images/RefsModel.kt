package model.images

data class RefsModel(
    val name: String,
    val type: String,
    val sport: String,
    val sportRadarId: String,
    val primary: Boolean,
    val entityIds: List<EntityIdsModel>
)
