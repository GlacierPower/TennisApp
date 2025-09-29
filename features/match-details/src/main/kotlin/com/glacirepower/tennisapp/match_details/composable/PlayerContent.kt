package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun PlayerContent(
    playerImage: String,
    playerName: String,
    playerRank: String,
    onPlayerClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = playerImage,
            contentDescription = playerImage,
            modifier = Modifier.clickable { onPlayerClick() }
        )

        TennisAppText(
            text = playerName,
            style = TennisTheme.typography.labelSmall
        )

        TennisAppText(
            text = playerRank,
            style = TennisTheme.typography.labelSmall
        )
    }
}
