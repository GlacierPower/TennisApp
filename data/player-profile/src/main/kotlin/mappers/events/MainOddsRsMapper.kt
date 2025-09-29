package mappers.events

import api.responce.player_events.MainOddsRs
import model.events.MainOddsModel

fun MainOddsRs.toMainOddsModel(): MainOddsModel {
    return MainOddsModel(
        outcome1 = outcome1.toOutcomeModel(),
        outcome2 = outcome2.toOutcomeModel()
    )
}
