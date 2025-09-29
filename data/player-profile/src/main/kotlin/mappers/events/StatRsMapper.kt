package mappers.events

import api.responce.player_events.StatRs
import model.events.StatModel

fun StatRs.toStatModel(): StatModel {
    return StatModel(
        home = home,
        away = away
    )
}
