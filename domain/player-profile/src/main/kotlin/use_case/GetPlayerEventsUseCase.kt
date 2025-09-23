package use_case

import repository.PlayerDetailsRepository
import javax.inject.Inject

class GetPlayerEventsUseCase @Inject constructor(
    private val playerDetailsRepository: PlayerDetailsRepository
) {
    suspend operator fun invoke(id: String) = playerDetailsRepository.getPlayerEvents(id)
}
