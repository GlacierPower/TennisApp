package com.glacierpower.tennisapp.data.service.responce.Events

import com.google.gson.annotations.SerializedName

data class Periods(
    @SerializedName("current")
    val current: String,
    @SerializedName("period1")
    val period1: String,
    @SerializedName("period2")
    val period2: String,
    @SerializedName("period3")
    val period3: String,
    @SerializedName("period4")
    val period4: String,
    @SerializedName("period5")
    val period5: String,
    @SerializedName("point")
    val point : String
)
