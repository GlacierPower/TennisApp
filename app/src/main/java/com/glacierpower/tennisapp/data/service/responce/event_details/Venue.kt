package com.glacierpower.tennisapp.data.service.responce.event_details

import com.glacierpower.tennisapp.data.service.responce.Country

data class Venue(
    val city:City,
    val country: Country,
    val id:Int,
    val stadium:Stadium

)

data class City(
    val name:String
)

data class Stadium(
    val name:String
)
