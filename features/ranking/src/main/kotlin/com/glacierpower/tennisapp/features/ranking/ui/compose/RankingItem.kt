package com.glacierpower.tennisapp.features.ranking.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun RankingItem(
    modifier: Modifier = Modifier,
    rank: String,
    name: String,
    points: String,
    onPlayerClick: () -> Unit,
    flagUri: String
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
                    vertical = TennisTheme.dimensions.padding.s,
                    horizontal = TennisTheme.dimensions.padding.l
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TennisAppText(
                    text = "${rank}.",
                    style = TennisTheme.typography.body3
                )
                TennisAppSpacer(size = TennisTheme.dimensions.base.spaserLarge)
                Image(
                    painter = rememberAsyncImagePainter(flagUri),
                    contentDescription = "description",
                    Modifier.size(width = 40.dp, height = 30.dp)
                )
                TennisAppSpacer(size = TennisTheme.dimensions.base.spaserLarge)
                TennisAppText(
                    text = name,
                    style = TennisTheme.typography.body3
                )
            }
            TennisAppText(
                text = points,
                style = TennisTheme.typography.body3
            )
        }
        TennisAppDivider()
    }
}
