package com.glacierpower.tennisapp.data.service.responce.Events

import com.google.gson.annotations.SerializedName

data class RoundInfo(
    @SerializedName("cupRoundType")
    val cupRoundType:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("round")
    val round:Int,
    @SerializedName("slug")
    val slug:String
)
