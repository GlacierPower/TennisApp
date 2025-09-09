package api.responce.images

import com.squareup.moshi.Json

data class Refs(
    val name: String,
    val type: String,
    val sport: String,
    @property:Json("sportradar_id")
    val sportRadarId: String,
    val primary: Boolean,
    @property:Json("entity_ids")
    val entityIds: List<EntityIds>
)
