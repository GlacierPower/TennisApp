package com.glacierpower.tennisapp.features.ranking.utils

import com.glacierpower.tennisapp.domain.ranking.model.RankingModel
import model.common.country_flag.Country

internal fun findFlagByCountry(countries: List<Country>?, countryIso: String): String? {
    return countries?.find {
        it.alpha2.equals(countryIso, ignoreCase = true) ||
            it.alpha3.equals(countryIso, ignoreCase = true) ||
            it.name.equals(countryIso, ignoreCase = true)
    }?.flagUrl.toString()
}

internal fun updateRankingsWithFlags(
    rankings: List<RankingModel>,
    countries: List<Country>?
): List<RankingModel> {
    return rankings.map { ranking ->
        val countryIso = ranking.team.country
        val flagUrl = findFlagByCountry(countries, countryIso)
        ranking.copyWithCountryFlag(flagUrl)
    }
}
