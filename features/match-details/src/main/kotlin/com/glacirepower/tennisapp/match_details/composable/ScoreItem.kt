package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun ScoreItem(
    set: String,
    homeScore: String,
    awayScore: String,
    homeTieBreak: String = "",
    awayTieBreak: String = "",
    setTime: String
) {
    Column(
        modifier = Modifier
            .padding(vertical = TennisTheme.dimensions.padding.s),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TennisAppText(
            text = set,
            style = TennisTheme.typography.labelSmall,
            modifier = Modifier
                .padding(bottom = TennisTheme.dimensions.padding.xs)
                .background(color = TennisTheme.colors.backgroundIsland)
        )

        AnnotatedScoreText(
            mainText = homeScore,
            annotation = homeTieBreak
        )

        AnnotatedScoreText(
            mainText = awayScore,
            annotation = awayTieBreak
        )
        TennisAppText(
            text = setTime,
            style = TennisTheme.typography.timeSmall,
            modifier = Modifier.padding(top = TennisTheme.dimensions.padding.xs)
        )
    }
}

@Composable
private fun AnnotatedScoreText(
    mainText: String,
    annotation: String
) {
    Box(
        contentAlignment = Alignment.TopEnd
    ) {
        TennisAppText(
            text = mainText,
            style = TennisTheme.typography.labelSmall,
            modifier = Modifier.padding(vertical = TennisTheme.dimensions.padding.xs)
        )

        TennisAppText(
            text = annotation,
            style = TennisTheme.typography.timeSmall,
            modifier = Modifier
                .offset(x = 4.dp, y = (-4).dp)
        )
    }
}
