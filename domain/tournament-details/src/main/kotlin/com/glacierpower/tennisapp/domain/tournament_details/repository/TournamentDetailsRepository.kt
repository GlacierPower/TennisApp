package com.glacierpower.tennisapp.domain.tournament_details.repository

import com.glacierpower.tennisapp.domain.tournament_details.model.TournamentModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface TournamentDetailsRepository {
    suspend fun getTournamentDetails(id: String): TennisResult<TournamentModel, DataError.NetworkError>
}
