package com.glacierpower.tennisapp.data.service.responce.player_near_events

import com.google.gson.annotations.SerializedName

data class PlayerNearEventsResponse(
    @SerializedName("nextEvent")
    val nextEvent:NextEvent?,
    @SerializedName("previousEvent")
    val previousEvent: PreviousEvent?
)
