package mappers

import api.responce.common.RoundInfoRs
import kotlinx.serialization.InternalSerializationApi
import model.events.RoundInfoModel

@OptIn(InternalSerializationApi::class)
fun RoundInfoRs.toRoundInfoModel(): RoundInfoModel {
    return RoundInfoModel(
        round = round,
        name = name,
        cupRoundType = cupRoundType
    )
}
