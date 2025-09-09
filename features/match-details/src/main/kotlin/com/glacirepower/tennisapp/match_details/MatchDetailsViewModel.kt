package com.glacirepower.tennisapp.match_details

import androidx.lifecycle.viewModelScope
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEffect
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEvent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsReducer
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsArgs
import com.glacirepower.tennisapp.match_details.use_case.GetEventDetailsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mvi.BaseViewModel
import network.tennisResult.TennisResult

@HiltViewModel(assistedFactory = MatchDetailsViewModel.MatchDetailsViewModelFactory::class)
class MatchDetailsViewModel @AssistedInject constructor(
    private val getEventDetailsUseCase: GetEventDetailsUseCase,
    @Assisted private val args: MatchDetailsArgs
) :
    BaseViewModel<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect>(
        initialState = MatchDetailsState(),
        reducer = MatchDetailsReducer()
    ) {

    init {
        getEventDetails()
    }

    private fun getEventDetails() {
        viewModelScope.launch {
            when (val result = getEventDetailsUseCase(args.eventId)) {
                is TennisResult.Error -> {}
                is TennisResult.Success -> {
                    sendEvent(MatchDetailsEvent.OnEventDetailsLoaded(result.data))
                }
            }
        }
    }

    @AssistedFactory
    internal interface MatchDetailsViewModelFactory {
        fun create(matchDetailsArgs: MatchDetailsArgs): MatchDetailsViewModel
    }
}
