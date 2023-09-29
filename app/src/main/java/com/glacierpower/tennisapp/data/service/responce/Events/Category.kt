package com.glacierpower.tennisapp.data.service.responce.Events

import com.glacierpower.tennisapp.data.service.responce.Sport

data class Category(
    val flag:String,
    val id:Int,
    val name:String,
    val slug:String,
    val sport:Sport
)
