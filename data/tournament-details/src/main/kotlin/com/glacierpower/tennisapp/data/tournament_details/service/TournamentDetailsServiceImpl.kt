package com.glacierpower.tennisapp.data.tournament_details.service

import api.api.TournamentApi
import com.glacierpower.tennisapp.data.tournament_details.mappers.toTournamentModel
import com.glacierpower.tennisapp.domain.tournament_details.model.TournamentModel
import network.tennisResult.DataError
import network.tennisResult.TennisResult
import networkHelper.NetworkHelper
import javax.inject.Inject

class TournamentDetailsServiceImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val tournamentApi: TournamentApi
) : TournamentDetailsService {
    override suspend fun getTournamentDetails(id: String): TennisResult<TournamentModel, DataError.NetworkError> {
        return networkHelper.fetchToTennisResult(
            apiCall = suspend { tournamentApi.getTournamentDetails(id) },
            mapper = { tournament ->
                tournament.toTournamentModel()
            }
        )
    }
}
