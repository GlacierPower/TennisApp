package com.glacirepower.tennisapp.match_details.use_case

import com.glacirepower.tennisapp.match_details.repository.EventRepository
import javax.inject.Inject

class GetEventDetailsUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(eventId: String) = eventRepository.getEventDetails(eventId)
}
