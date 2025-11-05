package use_case

import repository.PlayerDetailsRepository
import javax.inject.Inject

class GetPlayerDetailsUseCase @Inject constructor(
    private val playerDetailsRepository: PlayerDetailsRepository
) {
    suspend operator fun invoke(id: String) = playerDetailsRepository.getPlayerProfile(id)
}
