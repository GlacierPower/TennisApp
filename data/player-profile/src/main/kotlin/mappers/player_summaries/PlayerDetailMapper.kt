package mappers.player_summaries

import api.responce.player_details.DetailRs
import models.player_details.details.PlayerDetailModel

fun DetailRs.toPlayerDetailModel(): PlayerDetailModel {
    return PlayerDetailModel(
        country = country,
        countryIso = countryIso,
        dateOfBirth = dateOfBirth,
        birthplace = birthplace,
        plays = plays,
        residence = residence,
        weight = weight,
        heightMeters = heightMeters,
        prizeCurrent = prizeCurrent,
        prizeTotal = prizeTotal,
        prizeCurrentEuros = prizeCurrentEuros,
        prizeTotalEuros = prizeTotalEuros,
        flag = flag
    )
}
