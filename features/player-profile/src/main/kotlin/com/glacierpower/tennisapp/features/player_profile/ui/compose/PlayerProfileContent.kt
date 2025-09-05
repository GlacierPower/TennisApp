package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.features.player_profile.model.SummariesDvo
import theme.TennisTheme

@Composable
fun PlayerProfileContent(
    playerSummaries: List<SummariesDvo>,
    country: String,
    name: String,
    age: String,
    rankName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundGlobe)
    ) {
        PlayerProfileHeader(
            country = country,
            name = name,
            age = age,
            rank = rankName
        )
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 100.dp)
                .padding(horizontal = TennisTheme.dimensions.padding.l)
        ) {
            items(playerSummaries) { summary ->
                PreviousMatchItem(
                    date = summary.date,
                    homePlayerName = summary.homeName,
                    awayPlayerName = summary.awayName,
                    matchStatus = summary.matchStatus,
                    isWin = summary.isWin,
                    homeScore = summary.homeScore.toString(),
                    awayScore = summary.awayScore.toString(),
                    isHomeWin = summary.isHomeWin,
                    isAwayWin = summary.isAwayWin
                )
            }
        }
    }
}
