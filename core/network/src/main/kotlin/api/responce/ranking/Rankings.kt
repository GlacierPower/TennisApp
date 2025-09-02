
package api.responce.ranking

import com.squareup.moshi.Json

data class Rankings(
    @property:Json("type_id")
    val typeId: Int,
    val name: String,
    val year: Int,
    val week: Int,
    val gender: String,
    @property:Json("competitor_rankings")
    val competitorRankings: List<CompetitorRankings>
)
