
package api.responce.ranking

import com.squareup.moshi.Json

data class RankingResponse(
    @property:Json(name = "generated_at")
    val generatedAt: String,
    val rankings: List<Rankings>,
)
