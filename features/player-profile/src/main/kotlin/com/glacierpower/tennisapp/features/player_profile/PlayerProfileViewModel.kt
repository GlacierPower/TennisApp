package com.glacierpower.tennisapp.features.player_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.PlayerProfileModel
import network.tennisResult.TennisResult
import use_case.GetPlayerProfileUseCase
import javax.inject.Inject

@HiltViewModel
class PlayerProfileViewModel @Inject constructor(
    private val getPlayerProfileUseCase: GetPlayerProfileUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val playerId: StateFlow<String?> = savedStateHandle.getStateFlow("id", initialValue = null)
    private var _connection = MutableLiveData<Boolean>()
    val connection: LiveData<Boolean> get() = _connection

    private var _playerDetails = MutableLiveData<PlayerProfileModel>()
    val playerDetails: LiveData<PlayerProfileModel> get() = _playerDetails

    private var _convertTime = MutableLiveData<Long?>()
    val convertTime: LiveData<Long?> get() = _convertTime

    fun getPlayerDetails() {
        viewModelScope.launch {
            playerId.value?.let { id ->
                when (val result = getPlayerProfileUseCase(id)) {
                    is TennisResult.Error -> {}
                    is TennisResult.Success -> {
                        _playerDetails.value = result.data
                    }
                }
            }
        }
    }
}