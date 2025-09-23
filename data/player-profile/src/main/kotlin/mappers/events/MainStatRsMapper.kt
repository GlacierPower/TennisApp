package mappers.events

import api.responce.player_events.MainStatRs
import models.player_details.events.MainStatModel

fun MainStatRs.toMainStatModel(): MainStatModel {
    return MainStatModel(
        aces = aces?.toStatModel(),
        doubleFaults = doubleFaults?.toStatModel(),
        firstServe = firstServe?.toStatModel(),
        secondServe = secondServe?.toStatModel()
    )
}
