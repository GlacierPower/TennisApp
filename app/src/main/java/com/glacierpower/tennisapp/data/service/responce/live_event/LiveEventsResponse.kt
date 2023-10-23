package com.glacierpower.tennisapp.data.service.responce.live_event

import com.google.gson.annotations.SerializedName

data class LiveEventsResponse(
    @SerializedName("events")
    val events: MutableList<LiveEventList>
)
