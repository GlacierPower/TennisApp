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
    @field:Json(name = "country")
    val country: Country,
    @field:Json(name = "disabled")
    val disabled: Boolean,
    @field:Json(name = "gender")
    val gender: String? = null,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "nameCode")
    val nameCode: String,
    @field:Json(name = "national")
    val national: Boolean,
    @field:Json(name = "ranking")
    val ranking: Int,
    @field:Json(name = "shortName")
    val shortName: String,
    @field:Json(name = "slug")
    val slug: String,
    @field:Json(name = "sport")
    val sport: Sport,
    @field:Json(name = "teamColors")
    val teamColors: TeamColor,
    @field:Json(name = "type")
    val type: Int,
    @field:Json(name = "userCount")
    val userCount: Int

)

data class TeamColor(
    @field:Json(name = "primary")
    val primary: String,
    @field:Json(name = "secondary")
    val secondary: String,
    @field:Json(name = "text")
    val text: String
)

data class Sport(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "slug")
    val slug: String
)

data class Country(
    @field:Json(name = "alpha2")
    val alpha2: String? = null,
    @field:Json(name = "name")
    val name: String
)

