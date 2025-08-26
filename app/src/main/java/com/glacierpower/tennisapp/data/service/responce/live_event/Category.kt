package com.glacierpower.tennisapp.data.service.responce.live_event

import com.glacierpower.tennisapp.data.service.responce.Sport
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("flag")
    val flag:String,
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("slug")
    val slug:String,
    @SerializedName("sport")
    val sport:Sport
)
