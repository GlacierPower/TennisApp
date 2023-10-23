package com.glacierpower.tennisapp.domain.palyer_details

import com.glacierpower.tennisapp.model.lastEventModel.LastEventModel
import com.glacierpower.tennisapp.model.player_details.NextEventModel
import com.glacierpower.tennisapp.model.player_details.PlayerDetailsModel
import com.glacierpower.tennisapp.model.player_details.PlayerNearEventsModel
import com.glacierpower.tennisapp.utils.ResultState

interface PlayerDetailsRepository {

    suspend fun getPlayerDetails(id: Int):ResultState<PlayerDetailsModel>

    suspend fun getPlayerNearEvents(id:Int):ResultState<PlayerNearEventsModel>

    suspend fun getPlayerLastEvents(id:Int):ResultState<List<LastEventModel>>
}