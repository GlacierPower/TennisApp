package mappers

import api.responce.common.SeasonRs
import kotlinx.serialization.InternalSerializationApi
import model.events.SeasonModel

@OptIn(InternalSerializationApi::class)
fun SeasonRs.toSeasonModel(): SeasonModel {
    return SeasonModel(
        id = id,
        leagueId = leagueId,
        slug = slug,
        name = name,
        yearStart = yearStart,
        yearEnd = yearEnd
    )
}
