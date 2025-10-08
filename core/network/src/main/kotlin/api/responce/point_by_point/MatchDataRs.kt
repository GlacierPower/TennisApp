package api.responce.point_by_point

import com.squareup.moshi.Json

data class MatchDataRs(
    val id: Long,
    @property:Json("event_id")val eventId: Long,
    val type: List<SetDataRs>
)
