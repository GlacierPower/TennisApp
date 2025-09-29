package mappers.events

import api.responce.player_events.PlayerEventsRs
import model.events.PlayerEventsModel

fun PlayerEventsRs.toPlayerEventsModel(): PlayerEventsModel {
    return PlayerEventsModel(
        data = data.toPlayerEventsDataModel(),
        meta = meta.toMetaModel()
    )
}
