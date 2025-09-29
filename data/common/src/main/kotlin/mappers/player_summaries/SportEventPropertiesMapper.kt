
package mappers.player_summaries

import api.responce.player_summaries.SportEventProperties
import model.player_summaries.SportEventPropertiesModel

fun SportEventProperties.toSportEventPropertiesModel(): SportEventPropertiesModel {
    return SportEventPropertiesModel(
        enhancedStats = enhancedStats,
        scores = scores,
        detailedServeOutcomes = detailedServeOutcomes,
        playByPlay = playByPlay
    )
}
