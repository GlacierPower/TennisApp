package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.core.design_system.TennisAppTopBar
import com.glacierpower.tennisapp.core.design_system.buttons.TennisAppCircularButton
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.match_details.R
import theme.TennisTheme
import com.glacierpower.tennisapp.core.design_system.R as DsR

@Composable
fun MatchDetailsHeader(
    tournamentName: String,
    homeTeamImage: String,
    awayTeamImage: String,
    homeTeamName: String,
    awayTeamName: String,
    homeTeamRank: String,
    awayTeamRank: String,
    homeTeamScore: String,
    awayTeamScore: String,
    date: String,
    matchStatus: String,
    onHomeTeamClick: () -> Unit,
    onAwayTeamClick: () -> Unit,
    onTournamentClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundIsland)
    ) {
        TennisAppTopBar(
            title = R.string.event_details_title,
            leftIcon = DsR.drawable.ic_arrow_left,
            onLeftIconClick = { onBackClick() }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.m
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TennisAppText(
                text = tournamentName,
                style = TennisTheme.typography.labelSmall
            )
            TennisAppCircularButton(
                onClick = { onTournamentClick() },
                iconId = DsR.drawable.ic_arrow_right,
                modifier = Modifier.size(12.dp),
                colors = TennisTheme.colors.backgroundIsland
            )
        }
        TennisAppDivider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.m
                ),
        ) {
            PlayerContent(
                playerImage = homeTeamImage,
                playerName = homeTeamName,
                playerRank = homeTeamRank,
                onPlayerClick = { onHomeTeamClick() }
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TennisAppText(
                    text = date,
                    style = TennisTheme.typography.body3,
                )

                TennisAppText(
                    text = "$homeTeamScore - $awayTeamScore",
                    style = TennisTheme.typography.title1
                )
                TennisAppText(
                    text = matchStatus,
                    style = TennisTheme.typography.body3
                )
            }
            PlayerContent(
                playerImage = awayTeamImage,
                playerName = awayTeamName,
                playerRank = awayTeamRank,
                onPlayerClick = { onAwayTeamClick() }
            )
        }
    }
}

@Preview(
    name = "MatchDetailsHeader — Home Win (Light)",
    showBackground = true,
)
@Composable
fun PreviewMatchDetailsHeader_HomeWin_Light() {
    TennisTheme {
        MatchDetailsHeader(
            tournamentName = "ATP Finals",
            homeTeamImage = "https://via.placeholder.com/64.png?text=HOME",
            awayTeamImage = "https://via.placeholder.com/64.png?text=AWAY",
            homeTeamScore = "3",
            awayTeamScore = "1",
            date = "24.09.2025 20:00",
            matchStatus = "Finished",
            onHomeTeamClick = {},
            onAwayTeamClick = {},
            onTournamentClick = {},
            onBackClick = {},
            homeTeamName = "Sinner",
            awayTeamName = "Alcaraz",
            homeTeamRank = "2",
            awayTeamRank = "1"
        )
    }
}
