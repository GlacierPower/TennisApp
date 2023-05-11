package com.glacierpower.tennisapp.data.service.responce

import com.squareup.moshi.Json

data class SearchResponse(
    @field:Json(name = "result")
    val result: MutableList<SearchResult>
)

data class SearchResult(
    @field:Json(name = "entity")
    val searchEntity: SearchEntity,
    val score: Int,
    val type: String
)

data class SearchEntity(
    @field:Json(name = "country")
    val country: Country,
    @field:Json(name = "gender")
    val gender: String,
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
    val teamColor: TeamColor,
    @field:Json(name ="type")
    val type:Int,
    @field:Json(name = "userCount")
    val userCount:Int
)