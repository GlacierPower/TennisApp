package mappers.events

import api.responce.player_events.OutcomeRs
import model.events.OutcomeModel

fun OutcomeRs.toOutcomeModel(): OutcomeModel {
    return OutcomeModel(
        value = value,
        change = change
    )
}
