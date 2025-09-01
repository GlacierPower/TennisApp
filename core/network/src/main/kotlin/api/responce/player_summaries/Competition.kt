package api.responce.player_summaries

import com.squareup.moshi.Json

data class Competition(
    val id: String,
    val name: String,
    @property:Json("parent_id")
    val parentId: String,
    val type: String,
    val gender: String,
    val level: String
)
