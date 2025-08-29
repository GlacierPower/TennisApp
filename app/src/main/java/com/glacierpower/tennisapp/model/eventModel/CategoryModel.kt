package com.glacierpower.tennisapp.model.eventModel

import api.responce.common.Sport

data class CategoryModel(
    val flag:String,
    val id:Int,
    val name:String,
    val slug:String,
    val sport: Sport
)
