package mappers.events

import api.responce.player_events.MainOddsRs
import models.player_details.events.MainOddsModel

fun MainOddsRs.toMainOddsModel(): MainOddsModel {
    return MainOddsModel(
        outcome1 = outcome1.toOutcomeModel(),
        outcome2 = outcome2.toOutcomeModel()
    )
}
