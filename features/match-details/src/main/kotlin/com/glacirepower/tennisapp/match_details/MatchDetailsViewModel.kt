package com.glacirepower.tennisapp.match_details

import androidx.lifecycle.viewModelScope
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEffect
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEvent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsReducer
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsArgs
import com.glacirepower.tennisapp.match_details.use_case.GetEventPointByPointUseCase
import com.glacirepower.tennisapp.match_details.use_case.GetEventStatisticUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi
import mvi.BaseViewModel
import network.tennisResult.TennisResult
import timber.log.Timber

@InternalSerializationApi
@HiltViewModel(assistedFactory = MatchDetailsViewModel.MatchDetailsViewModelFactory::class)
class MatchDetailsViewModel @AssistedInject constructor(
    private val getEventPointByPointUseCase: GetEventPointByPointUseCase,
    private val getEventStatisticUseCase: GetEventStatisticUseCase,
    @Assisted private val args: MatchDetailsArgs
) :
    BaseViewModel<MatchDetailsState, MatchDetailsEvent, MatchDetailsEffect>(
        initialState = MatchDetailsState.init(args.event),
        reducer = MatchDetailsReducer()
    ), MatchDetailsIntent {

    init {
        getEventDetails()
        getPointByPoint()
        getStatistics()
    }

    private fun getPointByPoint() {
        val eventId = state.value.event?.id
        eventId?.let { id ->
            viewModelScope.launch {
                when (val result = getEventPointByPointUseCase(id)) {
                    is TennisResult.Error -> Timber.e(result.error.toString())
                    is TennisResult.Success -> {
                        sendEvent(MatchDetailsEvent.OnPointByPointLoaded(result.data.data))
                    }
                }
            }
        }
    }

    private fun getStatistics() {
        val eventId = state.value.event?.id
        eventId?.let { id ->
            viewModelScope.launch {
                when (val result = getEventStatisticUseCase(id)) {
                    is TennisResult.Error -> {}
                    is TennisResult.Success -> {
                        sendEvent(MatchDetailsEvent.OnStatisticsLoaded(result.data))
                    }
                }
            }
        }
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
        sendEffect(MatchDetailsEffect.NavigateToTournamentDetails(id))
    }

    override fun onSetClick(set: Int) {
        sendEvent(MatchDetailsEvent.OnUpdateSet(set))
    }

    @AssistedFactory
    internal interface MatchDetailsViewModelFactory {
        fun create(matchDetailsArgs: MatchDetailsArgs): MatchDetailsViewModel
    }
}
