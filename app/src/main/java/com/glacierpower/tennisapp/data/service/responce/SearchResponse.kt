package com.glacierpower.tennisapp.data.service.responce

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    val result: MutableList<SearchResult>
)

data class SearchResult(
    @SerializedName("entity")
    val searchEntity: SearchEntity,
    @SerializedName("score")
    val score: Float,
    @SerializedName("type")
    val type: String
)

data class SearchEntity(
    @SerializedName("country")
    val country: Country?,
    @SerializedName("disabled")
    val disabled: Boolean?,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameCode")
    val nameCode: String,
    @SerializedName("national")
    val national: Boolean,
    @SerializedName("ranking")
    val ranking: Int?,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("sport")
    val sport: Sport,
    @SerializedName("teamColor")
    val teamColor: TeamColor,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userCount")
    val userCount: Int
)