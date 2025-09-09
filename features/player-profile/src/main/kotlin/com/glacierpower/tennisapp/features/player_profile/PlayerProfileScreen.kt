package com.glacierpower.tennisapp.features.player_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacierpower.tennisapp.features.player_profile.args.ProfileArgs
import com.glacierpower.tennisapp.features.player_profile.ui.compose.PlayerProfileScreenContent
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileEffect

@Composable
fun PlayerProfileScreen(
    onNavigateBack: () -> Unit,
    onNavigateToDetails: (String) -> Unit,
    args: ProfileArgs,
    viewModel: PlayerProfileViewModel =
        hiltViewModel(creationCallback = { factory: PlayerProfileViewModel.PlayerProfileViewModelFactory ->
            factory.create(args)
        })
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                PlayerProfileEffect.NavigateBack -> onNavigateBack()
                is PlayerProfileEffect.NavigateToMatchDetails -> onNavigateToDetails(effect.eventId)
            }
        }
    }

    PlayerProfileScreenContent(
        state = state,
        intentListener = viewModel
    )
}
