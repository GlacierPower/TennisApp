package mappers

import api.responce.common.OutcomeRs
import kotlinx.serialization.InternalSerializationApi
import model.events.OutcomeModel

@OptIn(InternalSerializationApi::class)
fun OutcomeRs.toOutcomeModel(): OutcomeModel {
    return OutcomeModel(
        value = value,
        change = change
    )
}
