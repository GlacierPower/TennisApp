package com.glacierpower.tennisapp.feature.tournament_details

import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.domain.tournament_details.use_case.GetTournamentDetailsUseCase
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsEffect
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsEvent
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsReducer
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsState
import com.glacierpower.tennisapp.feature.tournament_details.navigation.TournamentDetailsArgs
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mvi.BaseViewModel
import mvi.ViewModelAssistedFactory
import network.tennisResult.TennisResult

@HiltViewModel(assistedFactory = TournamentDetailsViewModel.TournamentDetailsViewModelFactory::class)
class TournamentDetailsViewModel @AssistedInject constructor(
    private val getTournamentDetailsUseCase: GetTournamentDetailsUseCase,
    @Assisted private val args: TournamentDetailsArgs
) : BaseViewModel<TournamentDetailsState, TournamentDetailsEvent, TournamentDetailsEffect>(
    initialState = TournamentDetailsState(),
    reducer = TournamentDetailsReducer()
), TournamentDetailsIntent {

    init {
        getTournamentDetails()
    }

    private fun getTournamentDetails() {
        viewModelScope.launch {
            args.id?.let { id ->
                when (val result = getTournamentDetailsUseCase(id)) {
                    is TennisResult.Error -> {}
                    is TennisResult.Success -> {
                        sendEvent(TournamentDetailsEvent.OnTournamentDateLoaded(result.data.data))
                    }
                }
            }
        }
    }

    @AssistedFactory
    internal interface TournamentDetailsViewModelFactory :
        ViewModelAssistedFactory<TournamentDetailsArgs, TournamentDetailsViewModel>
}
