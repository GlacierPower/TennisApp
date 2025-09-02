package mappers.player_summaries

import api.responce.player_summaries.Coverage
import models.player_summaries.CoverageModel

fun Coverage.toCoverageModel(): CoverageModel{
    return CoverageModel(
        type = type,
        sportEventProperties = sportEventProperties.toSportEventPropertiesModel()
    )
}