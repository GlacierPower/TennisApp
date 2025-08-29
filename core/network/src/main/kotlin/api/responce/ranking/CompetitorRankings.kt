package api.responce.ranking

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class CompetitorRankings(
    val rank:Int,
    val movement:Int,
    val points:Int,
    @property:Json("competitions_played")
    val competitionsPlayed:Int,
    val competitor: Competitor
)
