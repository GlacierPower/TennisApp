package com.glacierpower.tennisapp.data.tournament_details.service

import com.glacierpower.tennisapp.domain.tournament_details.model.TournamentModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult

interface TournamentDetailsService {
    suspend fun getTournamentDetails(id: String): TennisResult<TournamentModel, DataError.NetworkError>
}
