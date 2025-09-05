package com.glacierpower.tennisapp.features.player_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEffect
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEvent
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileReducer
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import mvi.BaseViewModel
import use_case.GetPlayerProfileUseCase
import use_case.GetPlayerSummariesUseCase
import javax.inject.Inject

@HiltViewModel
class PlayerProfileViewModel @Inject constructor(
    private val getPlayerProfileUseCase: GetPlayerProfileUseCase,
    private val getPlayerSummariesUseCase: GetPlayerSummariesUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PlayerProfileState, PlayerProfileEvent, PlayerProfileEffect>(
    initialState = PlayerProfileState.initial(
        playerId = savedStateHandle.getStateFlow<String?>("id", initialValue = null).value,
        rank = savedStateHandle.getStateFlow<String?>("rank", initialValue = null).value
    ),
    reducer = PlayerProfileReducer()
), PlayerProfileIntent {
    init {
        getPlayerInfo()
    }

    private fun getPlayerInfo() {
        val playerId = state.value.playerId
        viewModelScope.launch {
            playerId?.let { id ->
                val profile = async {
                    getPlayerProfileUseCase(id)
                }.await()
                val summaries = async {
                    getPlayerSummariesUseCase(id)
                }.await()
                summaries.getOrNull()?.let {
                    sendEvent(
                        PlayerProfileEvent.OnPlayerInfoLoaded(
                            profile.getOrNull(),
                            it
                        )
                    )
                }
            }
        }
    }

    override fun onNavigateBack() {
        sendEffect(PlayerProfileEffect.NavigateBack)
    }
}
