package mappers.events

import api.responce.player_events.RoundInfoRs
import model.events.RoundInfoModel

fun RoundInfoRs.toRoundInfoModel(): RoundInfoModel {
    return RoundInfoModel(
        round = round,
        name = name,
        cupRoundType = cupRoundType
    )
}
