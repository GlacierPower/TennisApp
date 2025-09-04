package api.responce.player_summaries

import com.squareup.moshi.Json

data class Competitors(
    val id: String,
    val name: String,
    val country: String,
    val abbreviation: String,
    val qualifier: String,
    val seed: Int? = null,
    @property:Json("bracket_number")
    val bracketNumber: Int
)
