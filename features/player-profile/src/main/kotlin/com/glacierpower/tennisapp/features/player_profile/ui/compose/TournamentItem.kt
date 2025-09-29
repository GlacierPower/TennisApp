package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun TournamentItem(
    tournamentName: String,
    groundType: String,
    tournamentLogo: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundOnIsland)
            .padding(
                vertical = TennisTheme.dimensions.padding.s,
                horizontal = TennisTheme.dimensions.padding.l
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = TennisTheme.colors.iconPrimary,
                    shape = TennisTheme.shapes.s
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = tournamentLogo,
                contentDescription = null,
                modifier = Modifier
                    .size(TennisTheme.dimensions.icon.m)
                    .padding(TennisTheme.dimensions.padding.xs)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            TennisAppText(
                text = tournamentName,
                style = TennisTheme.typography.body2
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.m)
            TennisAppText(
                text = groundType,
                style = TennisTheme.typography.body3
            )
        }
    }
}
