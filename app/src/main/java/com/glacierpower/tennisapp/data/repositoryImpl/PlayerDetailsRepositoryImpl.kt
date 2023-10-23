package com.glacierpower.tennisapp.data.repositoryImpl

import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.palyer_details.PlayerDetailsRepository
import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class PlayerDetailsRepositoryImpl @Inject constructor(
    @Named("Tennis") private val tennisApiService: TennisApiService
) : PlayerDetailsRepository {
    override suspend fun getPlayerDetails(id: Int): ResultState<PlayerDetailsModel> {
        val playerDetailsResponse = tennisApiService.getPlayerDetails(id)
        return withContext(Dispatchers.IO) {
            ResultState.Success(playerDetailsResponse.body()!!.team.toEntity())
        }
    }

    override suspend fun getPlayerNearEvents(id: Int): ResultState<PlayerNearEventsModel> {
        val playerNearEventsResponse = tennisApiService.getPlayerNearEvents(id)
        return withContext(Dispatchers.IO) {
            ResultState.Success(playerNearEventsResponse.body()!!.toEntity())
        }
    }

    override suspend fun getPlayerLastEvents(id: Int): ResultState<List<LastEventModel>> {
        val playerLastEventsResponse = tennisApiService.getPlayerLastEvents(id)
        return withContext(Dispatchers.IO) {
            ResultState.Success(playerLastEventsResponse.body()!!.events.map {events->
                events.toEntity()
            })
        }
    }

}