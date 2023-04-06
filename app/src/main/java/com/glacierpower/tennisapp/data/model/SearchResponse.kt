package com.glacierpower.tennisapp.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("results")
    var results: MutableList<Results>
)

data class Results(
    @SerializedName("entity")
    var entity: Entity,
    @SerializedName("score")
    val score: Int,
    @SerializedName("type")
    val type: String
)

data class Entity(
    @SerializedName("country")
    var country: Country,
    @SerializedName("disabled")
    val disabled: Boolean = false,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameCode")
    val nameCode: String,
    @SerializedName("national")
    val national: Boolean = false,
    @SerializedName("ranking")
    val ranking: Int,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("sport")
    val sport: Sport,
    @SerializedName("teamColors")
    val teamColors: TeamColors,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userCount")
    var userCount: Int

)

data class Country(
    @SerializedName("alpha2")
    val alpha2: String,
    @SerializedName("name")
    val name: String
)

data class Sport(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)

data class TeamColors(
    @SerializedName("primary")
    val primary: Int,
    @SerializedName("secondary")
    val secondary: Int,
    @SerializedName("text")
    val text: String
)


