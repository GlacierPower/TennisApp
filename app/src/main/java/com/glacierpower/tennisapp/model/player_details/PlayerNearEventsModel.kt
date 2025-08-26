package com.glacierpower.tennisapp.model.player_details

import com.glacierpower.tennisapp.data.service.responce.player_near_events.NextEvent
import com.glacierpower.tennisapp.data.service.responce.player_near_events.PreviousEvent
import com.google.gson.annotations.SerializedName

data class PlayerNearEventsModel(
    val nextEvent: NextEventModel?,
    val previousEvent: PreviousEventModel
)
