package use_case

import repository.CompetitorsRepository
import javax.inject.Inject

class GetPlayerProfileUseCase @Inject constructor(
    private val competitorsRepository: CompetitorsRepository
) {
    suspend operator fun invoke(id: String) = competitorsRepository.getPlayerProfile(id)
}