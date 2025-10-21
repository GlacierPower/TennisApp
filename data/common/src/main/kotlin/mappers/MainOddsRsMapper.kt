package mappers

import api.responce.common.MainOddsRs
import kotlinx.serialization.InternalSerializationApi
import model.events.MainOddsModel

@OptIn(InternalSerializationApi::class)
fun MainOddsRs.toMainOddsModel(): MainOddsModel {
    return MainOddsModel(
        outcome1 = outcome1.toOutcomeModel(),
        outcome2 = outcome2.toOutcomeModel()
    )
}
