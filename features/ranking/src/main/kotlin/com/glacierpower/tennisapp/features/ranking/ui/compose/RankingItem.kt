package com.glacierpower.tennisapp.features.ranking.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.TennisAppText
import com.glacierpower.tennisapp.features.ranking.utils.formatName
import theme.TennisTheme

@Composable
fun RankingItem(
    modifier: Modifier = Modifier,
    rank: String,
    name: String,
    points: String,
    onPlayerClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = TennisTheme.colors.backgroundGlobe)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onPlayerClick() }
                .padding(
                    vertical = TennisTheme.dimensions.paddingSmall,
                    horizontal = TennisTheme.dimensions.paddingLarge
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                TennisAppText(
                    text = "${rank}.",
                    style = TennisTheme.typography.body2
                )
                TennisAppSpacer(size = TennisTheme.dimensions.spaserLarge)
                TennisAppText(
                    text = name.formatName(),
                    style = TennisTheme.typography.body2
                )
            }
            TennisAppText(
                text = points,
                style = TennisTheme.typography.body2
            )
        }
        TennisAppDivider()
    }
}
