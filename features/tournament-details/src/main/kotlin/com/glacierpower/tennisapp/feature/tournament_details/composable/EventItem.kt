package com.glacierpower.tennisapp.feature.tournament_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun EventItem(
    homeName: String,
    awayName: String,
    homeScore: Int,
    awayScore: Int,
    onEventClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(TennisTheme.colors.backgroundIsland, shape = TennisTheme.shapes.xs)
            .clickable { onEventClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(TennisTheme.dimensions.padding.s),
            verticalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.s)
        ) {
            TennisAppText(
                text = homeName,
                style = TennisTheme.typography.labelSmall
            )
            TennisAppText(
                text = awayName,
                style = TennisTheme.typography.labelSmall
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(TennisTheme.dimensions.padding.s),
            verticalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.s)
        ) {
            TennisAppText(
                text = homeScore.toString(),
                style = TennisTheme.typography.labelSmall
            )
            TennisAppText(
                text = awayScore.toString(),
                style = TennisTheme.typography.labelSmall
            )
        }
    }
}
