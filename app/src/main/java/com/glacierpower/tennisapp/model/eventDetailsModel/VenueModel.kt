package com.glacierpower.tennisapp.model.eventDetailsModel

import com.glacierpower.tennisapp.model.rankingModel.CountryModel

data class VenueModel(
    val city:CityModel,
    val country: CountryModel,
    val id:Int,
    val stadium:StadiumModel

)

data class CityModel(
    val name:String
)

data class StadiumModel(
    val name:String
)

