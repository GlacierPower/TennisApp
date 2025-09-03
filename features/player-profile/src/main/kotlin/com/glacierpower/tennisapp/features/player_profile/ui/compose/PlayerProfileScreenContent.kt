package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.buttons.TennisAppCircularButton
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.player_profile.PlayerProfileIntent
import com.glacierpower.tennisapp.features.player_profile.R
import com.glacierpower.tennisapp.features.player_profile.ui.mvi.PlayerProfileState
import theme.TennisTheme
import utils.formatName
import com.glacierpower.tennisapp.core.design_system.R as DsR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerProfileScreenContent(
    state: PlayerProfileState,
    intentListener: PlayerProfileIntent
) {
    Scaffold(
        containerColor = TennisTheme.colors.backgroundGlobe,
        modifier = Modifier
            .systemBarsPadding(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = TennisTheme.dimensions.padding.paddingXl),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TennisTheme.colors.backgroundGlobe
                ),
                title = {
                    TennisAppText(
                        text = stringResource(R.string.player_profile_app_bar_title),
                        style = TennisTheme.typography.title1

                    )
                },
                navigationIcon = {
                    TennisAppCircularButton(
                        iconId = DsR.drawable.ic_back,
                        onClick = intentListener::onNavigateBack
                    )
                }
            )
        }
    ) { paddingValues ->
        state.playerProfile?.let { player ->
            PlayerProfileContent(
                modifier = Modifier.padding(paddingValues),
                country = player.competitor.country,
                name = player.competitor.name.formatName(),
                age = stringResource(
                    R.string.player_profile_age,
                    player.info.age,
                    player.info.dateOfBirth
                )
            )
        }
    }
}
