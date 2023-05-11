package com.glacierpower.tennisapp.model.resultModel

import com.glacierpower.tennisapp.data.service.responce.Country
import com.glacierpower.tennisapp.model.rankingModel.ColorModel
import com.glacierpower.tennisapp.model.rankingModel.CountryModel
import com.glacierpower.tennisapp.model.rankingModel.SportModel

data class EntityModel(
    val country: CountryModel,
    val gender: String,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val ranking: Int,
    val shortName: String,
    val slug: String,
    val sport: SportModel,
    val teamColor: ColorModel,
    val type:Int,
    val userCount:Int
)
