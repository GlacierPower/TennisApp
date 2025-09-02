package use_case

import repository.CompetitorsRepository
import javax.inject.Inject

class GetPlayerSummariesUseCase @Inject constructor(
    private val competitorsRepository: CompetitorsRepository
) {
    suspend operator fun invoke(id: String) = competitorsRepository.getPlayerSummaries(id)
}
