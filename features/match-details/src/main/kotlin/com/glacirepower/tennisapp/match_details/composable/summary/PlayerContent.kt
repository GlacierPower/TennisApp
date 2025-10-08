package com.glacirepower.tennisapp.match_details.composable.summary

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
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
    isWinner: Boolean,
    onPlayerClick: () -> Unit
) {
    val winnerTextStyle =
        if (isWinner) TennisTheme.typography.body3 else TennisTheme.typography.labelSmall
    Column(
        modifier = Modifier.size(TennisTheme.dimensions.base.playerProfileItem),
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
            style = winnerTextStyle
        )

        TennisAppText(
            text = playerRank,
            style = TennisTheme.typography.labelSmall
        )
    }
}
