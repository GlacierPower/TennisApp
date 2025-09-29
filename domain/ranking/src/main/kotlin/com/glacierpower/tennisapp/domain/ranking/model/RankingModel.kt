package com.glacierpower.tennisapp.domain.ranking.model

data class RankingModel(
    val id: Int,
    val type: String,
    val points: Int,
    val ranking: Int,
    val tournaments: Int?,
    val officialUpdatedAt: String,
    val team: TeamModel,
    val countryFlag: String? = null
) {
    fun copyWithCountryFlag(flag: String?): RankingModel {
        return this.copy(countryFlag = flag)
    }
}
