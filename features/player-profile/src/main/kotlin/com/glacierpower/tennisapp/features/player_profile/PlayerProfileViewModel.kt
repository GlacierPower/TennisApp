package com.glacierpower.tennisapp.features.player_profile

import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.features.player_profile.args.ProfileArgs
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEffect
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEvent
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileReducer
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi
import model.common.country_flag.CountryDataGenerator.generateCountries
import mvi.BaseViewModel
import network.tennisResult.TennisResult
import timber.log.Timber
import use_case.GetPlayerDetailsUseCase
import use_case.GetPlayerEventsUseCase

@InternalSerializationApi
@HiltViewModel(assistedFactory = PlayerProfileViewModel.PlayerProfileViewModelFactory::class)
class PlayerProfileViewModel @AssistedInject constructor(
    private val getPlayerDetailsUseCase: GetPlayerDetailsUseCase,
    private val getPlayerEventsUseCase: GetPlayerEventsUseCase,
    @Assisted private val args: ProfileArgs,
) : BaseViewModel<PlayerProfileState, PlayerProfileEvent, PlayerProfileEffect>(
    initialState = PlayerProfileState(),
    reducer = PlayerProfileReducer()
), PlayerProfileIntent {

    init {
        sendEvent(PlayerProfileEvent.OnUpdatePlayerData(playerId = args.id))
        getPlayerInfo()
    }

    private fun getCountryFlags() {
        viewModelScope.launch {
            sendEvent(PlayerProfileEvent.OnUpdateCountryFlag(generateCountries()))
        }
    }

    private fun getPlayerInfo() {
        val playerId = state.value.playerId
        viewModelScope.launch {
            playerId?.let { id ->
                when (val result = getPlayerDetailsUseCase(id)) {
                    is TennisResult.Error -> {
                        Timber.e(result.error.toString())
                    }

                    is TennisResult.Success -> {
                        sendEvent(PlayerProfileEvent.OnPlayerInfoLoaded(result.data))
                        getCountryFlags()
                        getPlayerEvent()
                    }
                }
            }
        }
    }

    private fun getPlayerEvent() {
        val playerId = state.value.playerId
        viewModelScope.launch {
            playerId?.let { id ->
                when (val result = getPlayerEventsUseCase(id)) {
                    is TennisResult.Error -> Timber.e(result.error.toString())
                    is TennisResult.Success -> {
                        sendEvent(PlayerProfileEvent.OnPlayerEventsLoaded(result.data.data))
                    }
                }
            }
        }
    }

    override fun onNavigateBack() {
        sendEffect(PlayerProfileEffect.NavigateBack)
    }

    override fun onNavigateToMatchDetails(eventId: String) {
        sendEventForEffect(PlayerProfileEvent.OnNavigateToMatchDetails(eventId))
    }

    @AssistedFactory
    internal interface PlayerProfileViewModelFactory {
        fun create(profileArgs: ProfileArgs): PlayerProfileViewModel
    }
}
