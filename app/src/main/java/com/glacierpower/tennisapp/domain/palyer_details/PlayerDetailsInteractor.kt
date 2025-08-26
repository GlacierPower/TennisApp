package com.glacierpower.tennisapp.domain.palyer_details

import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.model.player_details.NextEventModel
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.utils.ResultState
import javax.inject.Inject

class PlayerDetailsInteractor @Inject constructor(private val playerDetailsRepository: PlayerDetailsRepository) {

    suspend fun getPlayerDetails(id: Int): ResultState<PlayerDetailsModel> {
        return playerDetailsRepository.getPlayerDetails(id)
    }

    suspend fun getPlayerNearEvents(id:Int):ResultState<PlayerNearEventsModel>{
        return playerDetailsRepository.getPlayerNearEvents(id)
    }


    suspend fun getPlayerLastEvents(id:Int):ResultState<List<LastEventModel>>{
        return playerDetailsRepository.getPlayerLastEvents(id)
    }
}