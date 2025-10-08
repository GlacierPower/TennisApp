package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.TennisAppTopBar
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileIntent
import com.glacierpower.tennisapp.features.player_profile.R
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileState
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme
import com.glacierpower.tennisapp.core.design_system.R as DsR

@InternalSerializationApi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerProfileScreenContent(
    state: PlayerProfileState,
    intentListener: PlayerProfileIntent
) {
    Column(
        modifier = Modifier.background(TennisTheme.colors.backgroundGlobe)
    ) {
        TennisAppTopBar(
            title = R.string.player_profile_app_bar_title,
            leftIcon = DsR.drawable.ic_arrow_left,
            onLeftIconClick = intentListener::onNavigateBack
        )
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = TennisTheme.colors.iconPrimary
                )
            }
        } else {
            state.playerProfile?.let { player ->
                PlayerProfileContent(
                    country = player.country,
                    name = player.name,
                    age = stringResource(
                        R.string.player_profile_age_template,
                        player.details?.dateOfBirth.orEmpty()
                    ),
                    playerEvents = state.events,
                    rankName = "ATP: ${player.tennisRanking?.ranking}",
                    onMatchClick = intentListener::onNavigateToMatchDetails,
                    imageUrl = player.logo,
                    flagUrl = state.flagUrl.toString()
                )
            }
        }
    }
}
