package com.glacirepower.tennisapp.match_details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacirepower.tennisapp.match_details.composable.MatchDetailsScreenContent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsEffect
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsArgs
import com.glacirepower.tennisapp.match_details.navigation.MatchDetailsNavigator
import kotlinx.serialization.InternalSerializationApi

@OptIn(ExperimentalMaterial3Api::class)
@InternalSerializationApi
@Composable
fun MatchDetailsScreen(
    args: MatchDetailsArgs,
    navigator: MatchDetailsNavigator,
    viewModel: MatchDetailsViewModel =
        hiltViewModel(creationCallback = { factory: MatchDetailsViewModel.MatchDetailsViewModelFactory ->
            factory.create(args)
        })
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is MatchDetailsEffect.NavigateBack -> navigator.navigateBack()
                is MatchDetailsEffect.NavigateToPlayerDetails -> navigator.navigateToPlayerDetails(
                    effect.playerId
                )

                is MatchDetailsEffect.NavigateToTournamentDetails -> {
                    navigator.navigateToTournamentDetails(effect.tournamentId)
                }
            }
        }
    }

    MatchDetailsScreenContent(state = state, matchDetailsIntent = viewModel)
}
