package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileViewModel
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEffect

@Composable
fun PlayerProfileScreen(
    onNavigateBack: () -> Unit
) {
    val viewModel: PlayerProfileViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                PlayerProfileEffect.NavigateBack -> onNavigateBack()
            }
        }
    }
    PlayerProfileScreenContent(
        state = state,
        intentListener = viewModel
    )
}
