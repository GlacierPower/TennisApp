package api.responce.statistics

import com.squareup.moshi.Json

data class StatisticRs(
    val id: Int,
    @property:Json("event_id") val eventId: Int,
    val period: String,
    val group: String,
    val name: String,
    val home: String,
    val away: String,
    @property:Json("compare_code") val compareCode: Int
)
