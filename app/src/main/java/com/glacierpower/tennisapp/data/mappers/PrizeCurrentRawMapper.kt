
package com.glacierpower.tennisapp.data.mappers

import com.glacierpower.tennisapp.data.service.responce.player_details.PrizeCurrentRaw
import com.glacierpower.tennisapp.model.player_details.PrizeCurrentRawModel

fun PrizeCurrentRaw.toEntity(): PrizeCurrentRawModel {
    return PrizeCurrentRawModel(
        currency, value
    )
}
