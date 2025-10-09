package com.glacierpower.tennisapp.data.tournament_details.repository

import com.glacierpower.tennisapp.data.tournament_details.service.TournamentDetailsService
import com.glacierpower.tennisapp.domain.tournament_details.model.TournamentModel
import com.glacierpower.tennisapp.domain.tournament_details.repository.TournamentDetailsRepository
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import javax.inject.Inject

class TournamentDetailsRepositoryImpl @Inject constructor(
    private val tournamentDetailsService: TournamentDetailsService
) : TournamentDetailsRepository {
    override suspend fun getTournamentDetails(id: String): TennisResult<TournamentModel, DataError.NetworkError> =
        tournamentDetailsService.getTournamentDetails(id)
}
