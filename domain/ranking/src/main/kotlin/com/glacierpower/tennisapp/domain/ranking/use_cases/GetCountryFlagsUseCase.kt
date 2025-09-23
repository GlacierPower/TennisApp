package com.glacierpower.tennisapp.domain.ranking.use_cases

import com.glacierpower.tennisapp.domain.ranking.repository.RankingRepository
import javax.inject.Inject

class GetCountryFlagsUseCase @Inject constructor(
    private val rankingRepository: RankingRepository
) {
    suspend operator fun invoke() = rankingRepository.getCountryFlags()
}
