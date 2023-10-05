package com.glacierpower.tennisapp.data.service.responce.Events

import com.google.gson.annotations.SerializedName

data class Changes(
    @SerializedName("changeTimestamp")
    val changeTimestamp:Int,
    @SerializedName("changes")
    val changes:List<String>?
)
