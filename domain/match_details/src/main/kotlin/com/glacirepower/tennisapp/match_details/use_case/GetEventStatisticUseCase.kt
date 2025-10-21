package com.glacirepower.tennisapp.match_details.use_case

import com.glacirepower.tennisapp.match_details.repository.MatchDetailsRepository
import javax.inject.Inject

class GetEventStatisticUseCase @Inject constructor(
    private val matchDetailsRepository: MatchDetailsRepository
) {
    suspend operator fun invoke(id: String) = matchDetailsRepository.getEventStatistics(id)
}
