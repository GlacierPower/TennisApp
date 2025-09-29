
package mappers.player_summaries

import api.responce.player_summaries.Round
import model.player_summaries.RoundModel

fun Round.toRoundModel(): RoundModel {
    return RoundModel(
        name = name
    )
}
