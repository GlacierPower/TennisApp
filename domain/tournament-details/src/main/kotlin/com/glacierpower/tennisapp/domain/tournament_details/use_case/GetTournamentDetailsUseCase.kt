package com.glacierpower.tennisapp.domain.tournament_details.use_case

import com.glacierpower.tennisapp.domain.tournament_details.repository.TournamentDetailsRepository
import javax.inject.Inject

class GetTournamentDetailsUseCase @Inject constructor(
    private val tournamentDetailsRepository: TournamentDetailsRepository
) {
    suspend operator fun invoke(id: String) = tournamentDetailsRepository.getTournamentDetails(id)
}
