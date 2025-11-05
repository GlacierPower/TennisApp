package com.glacirepower.tennisapp.match_details.mappers

import com.glacirepower.tennisapp.match_details.model.MainStatsDvo
import com.glacirepower.tennisapp.match_details.model.StatDvo
import kotlinx.serialization.InternalSerializationApi
import model.events.MainStatModel
import model.events.StatModel
import utils.orZero

@OptIn(InternalSerializationApi::class)
fun MainStatModel.toMainStatsDvo(): MainStatsDvo {
    return MainStatsDvo(
        aces = aces?.toStatDvo(),
        doubleFaults = doubleFaults?.toStatDvo(),
        firstServe = firstServe?.toStatDvo(),
        secondServe = secondServe?.toStatDvo()
    )
}

@OptIn(InternalSerializationApi::class)
private fun StatModel.toStatDvo(): StatDvo {
    return StatDvo(
        home = home.orZero(),
        away = away.orZero()
    )
}
