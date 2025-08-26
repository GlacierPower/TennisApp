package com.glacierpower.tennisapp.model.eventModel

import com.glacierpower.tennisapp.data.service.responce.Sport

data class CategoryModel(
    val flag:String,
    val id:Int,
    val name:String,
    val slug:String,
    val sport: Sport
)
