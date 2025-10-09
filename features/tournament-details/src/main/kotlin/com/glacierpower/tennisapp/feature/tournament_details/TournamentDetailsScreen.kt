package com.glacierpower.tennisapp.feature.tournament_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacierpower.tennisapp.feature.tournament_details.composable.TournamentDetailsContent
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsEffect
import com.glacierpower.tennisapp.feature.tournament_details.navigation.TournamentDetailsArgs

@Composable
fun TournamentDetailsScreen(
    args: TournamentDetailsArgs,
    viewModel: TournamentDetailsViewModel = hiltViewModel(
        creationCallback = { factory: TournamentDetailsViewModel.TournamentDetailsViewModelFactory ->
            factory.create(args)
        }
    )
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                TournamentDetailsEffect.NavigateBack -> {}
                is TournamentDetailsEffect.NavigateToPlayerDetails -> {}
            }
        }
    }
    TournamentDetailsContent(state = state, intentListener = viewModel)
}
