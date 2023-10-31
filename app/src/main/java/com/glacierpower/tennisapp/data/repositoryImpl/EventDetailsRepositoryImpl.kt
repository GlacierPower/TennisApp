package com.glacierpower.tennisapp.data.repositoryImpl

import com.glacierpower.tennisapp.data.mappers.toEntity
import com.glacierpower.tennisapp.data.service.TennisApiService
import com.glacierpower.tennisapp.domain.event_details.EventDetailsRepository
import com.glacierpower.tennisapp.model.eventDetailsModel.EventDetailsModel
import com.glacierpower.tennisapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class EventDetailsRepositoryImpl @Inject constructor(
    @Named("Tennis") private val tennisApiService: TennisApiService
) : EventDetailsRepository {
    override suspend fun getEventDetails(id: Int): ResultState<EventDetailsModel> {
       val response = tennisApiService.getEventDetails(id)
        return withContext(Dispatchers.IO){
            ResultState.Success(response.body()!!.event.toEntity())
        }
    }

}