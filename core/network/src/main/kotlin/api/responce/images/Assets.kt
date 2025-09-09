package api.responce.images

import com.squareup.moshi.Json

data class Assets(
    val id: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String,
    @property:Json("player_id")
    val playerId: String? = null,
    val copyright: String,
    val posed: Boolean? = false,
    val links: List<Links>,
    val refs: List<Refs> = emptyList(),
    val provider: Provider
)
