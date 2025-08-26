package com.glacierpower.tennisapp.model.rankingModel

data class TeamModel(
    val country: CountryModel,
    val disabled: Boolean,
    val fullName:String?,
    val gender: String? = null,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val ranking: Int,
    val shortName: String,
    val slug: String,
    val sport: SportModel,
    val teamColor: ColorModel,
    val type: Int,
    val userCount: Int
)