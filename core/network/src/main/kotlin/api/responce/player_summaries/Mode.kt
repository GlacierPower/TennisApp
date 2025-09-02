package api.responce.player_summaries

import com.squareup.moshi.Json

data class Mode(
    @property:Json("best_of")
    val bestOf: Int
)
