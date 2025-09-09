package com.glacierpower.tennisapp.features.player_profile

import android.util.Log
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
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import mvi.BaseViewModel
import use_case.GetPlayerProfileUseCase
import use_case.GetPlayerSummariesUseCase
import use_case.GetPlayersImagesManifestUseCase

@HiltViewModel(assistedFactory = PlayerProfileViewModel.PlayerProfileViewModelFactory::class)
class PlayerProfileViewModel @AssistedInject constructor(
    private val getPlayerProfileUseCase: GetPlayerProfileUseCase,
    private val getPlayerSummariesUseCase: GetPlayerSummariesUseCase,
    private val getPlayersImagesManifestUseCase: GetPlayersImagesManifestUseCase,
    @Assisted private val args: ProfileArgs,
) : BaseViewModel<PlayerProfileState, PlayerProfileEvent, PlayerProfileEffect>(
    initialState = PlayerProfileState(),
    reducer = PlayerProfileReducer()
), PlayerProfileIntent {

    init {
        sendEvent(PlayerProfileEvent.OnUpdatePlayerData(playerId = args.id, rank = args.rank))
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
                val image = async {
                    getPlayersImagesManifestUseCase()
                }.await()
                Log.d("Images", "${image}")
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

    override fun onNavigateToMatchDetails(eventId: String) {
        sendEffect(PlayerProfileEffect.NavigateToMatchDetails(eventId))
    }

    @AssistedFactory
    internal interface PlayerProfileViewModelFactory {
        fun create(profileArgs: ProfileArgs): PlayerProfileViewModel
    }
}
