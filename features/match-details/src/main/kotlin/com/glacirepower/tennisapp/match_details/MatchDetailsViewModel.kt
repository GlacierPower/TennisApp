package com.glacirepower.tennisapp.match_details

import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEffect
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEvent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsReducer
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsArgs
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.InternalSerializationApi
import mvi.BaseViewModel

@InternalSerializationApi
@HiltViewModel(assistedFactory = MatchDetailsViewModel.MatchDetailsViewModelFactory::class)
class MatchDetailsViewModel @AssistedInject constructor(
    @Assisted private val args: MatchDetailsArgs
) :
    BaseViewModel<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect>(
        initialState = MatchDetailsState.init(args.event),
        reducer = MatchDetailsReducer()
    ), MatchDetailsIntent {

    init {
        getEventDetails()
    }

    private fun getEventDetails() {
        sendEvent(MatchDetailsEvent.OnEventDetailsLoaded)
    }

    override fun onNavigateBack() {
        sendEffect(MatchDetailsEffect.NavigateBack)
    }

    override fun onHomeTeamClick(id: String) {
        sendEffect(MatchDetailsEffect.NavigateToPlayerDetails(id))
    }

    override fun onAwayTeamClick(id: String) {
        sendEffect(MatchDetailsEffect.NavigateToPlayerDetails(id))
    }

    override fun onTournamentClick(id: String) {
        TODO("Not yet implemented")
    }

    @AssistedFactory
    internal interface MatchDetailsViewModelFactory {
        fun create(matchDetailsArgs: MatchDetailsArgs): MatchDetailsViewModel
    }
}
