package com.glacirepower.tennisapp.match_details.composable.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacirepower.tennisapp.match_details.model.TotalScoreDvo
import theme.TennisTheme

@Composable
fun TotalScoreContent(
    scoreDvo: TotalScoreDvo
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(TennisTheme.colors.backgroundIsland),
    ) {
        TotalScore(
            scoreDvo
        )
    }
}
