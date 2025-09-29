package mappers.events

import api.responce.player_events.MainStatRs
import model.events.MainStatModel

fun MainStatRs.toMainStatModel(): MainStatModel {
    return MainStatModel(
        aces = aces?.toStatModel(),
        doubleFaults = doubleFaults?.toStatModel(),
        firstServe = firstServe?.toStatModel(),
        secondServe = secondServe?.toStatModel()
    )
}
