package com.glacierpower.tennisapp.data.service.responce

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class RankingResponse(
    val rankings: MutableList<Rankings>,
    val updatedAtTimestamp: Int
)

data class Rankings(
    @field:Json(name = "bestRanking")
    val bestRanking: Int,
    @field:Json(name = "bestRankingDateTimestamp")
    val bestRankingDateTimestamp: Int,
    @field:Json(name = "country")
    val country: Country,
    @field:Json(name = "id")
    val id: Int,
    @SerializedName("points")
    val points: Int,
    @field:Json(name = "previousPoints")
    val previousPoints: Int,
    @field:Json(name = "previousRanking")
    val previousRanking: Int,
    @SerializedName( "ranking")
    val ranking: Int,
    @field:Json(name = "rankingClass")
    val rankingClass: String,
    @field:Json(name = "rowName")
    val rowName: String,
    @field:Json(name = "team")
    val team: Team,
    @field:Json(name = "tournamentsPlayed")
    val tournamentsPlayed: Int,
    @field:Json(name = "type")
    val type: Int
)

data class Team(
    @SerializedName("country")
    val country: Country,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameCode")
    val nameCode: String,
    @SerializedName("national")
    val national: Boolean,
    @SerializedName("ranking")
    val ranking: Int,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("sport")
    val sport: Sport,
    @SerializedName("teamColors")
    val teamColors: TeamColor,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userCount")
    val userCount: Int

)

data class TeamColor(
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: String,
    @SerializedName("text")
    val text: String
)

data class Sport(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)

data class Country(
    @SerializedName("alpha2")
    val alpha2: String? = null,
    @SerializedName("name")
    val name: String
)

