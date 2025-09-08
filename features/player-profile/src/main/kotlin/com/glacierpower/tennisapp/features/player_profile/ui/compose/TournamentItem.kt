package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun TournamentItem(
    tournamentName: String,
    countryName: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundOnIsland)
            .padding(
                vertical = TennisTheme.dimensions.padding.s,
                horizontal = TennisTheme.dimensions.padding.l
            )
    ) {
        TennisAppText(
            text = tournamentName,
            style = TennisTheme.typography.body2
        )
        TennisAppSpacer(size = TennisTheme.dimensions.space.space10)
        TennisAppText(
            text = countryName,
            style = TennisTheme.typography.body3
        )
    }
}
