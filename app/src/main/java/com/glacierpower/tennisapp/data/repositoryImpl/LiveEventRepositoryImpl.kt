package com.glacierpower.tennisapp.data.repositoryImpl

import android.util.Log
import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.CountriesFlagsApiService
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.events.LiveEventsRepository
import com.glacierpower.tennisapp.model.eventModel.EventModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class LiveEventRepositoryImpl @Inject constructor(
    @Named("Tennis") private val tennisApiService: TennisApiService,
    @Named("Countries Flags") private val countriesFlagsApiService: CountriesFlagsApiService
) : LiveEventsRepository {
    override suspend fun getLiveEvent(): ResultState<List<EventModel>> {
        val liveEventResponse = tennisApiService.getLiveEvents()
        return withContext(Dispatchers.IO) {
            ResultState.Success(liveEventResponse.body()?.events.let { list ->
                list!!.map { liveEventList ->
                    liveEventList.toEntity()
                }
            })
        }
    }

    override suspend fun getTournamentImage(id: Int) {
        tennisApiService.getTournamentImage(id).raw().request.url.query
        Log.w("Image url", "${tennisApiService.getTournamentImage(id)}")
    }

    override suspend fun getCountryFlag(code: String) {
        countriesFlagsApiService.getCountryFlag(code).raw().request.url
    }

}
