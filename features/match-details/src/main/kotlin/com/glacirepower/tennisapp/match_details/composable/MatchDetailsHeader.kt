package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
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
    awayReamImage: String,
    homeTeamScore: Int,
    awayTeamScore: Int,
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
                colors = TennisTheme.colors.iconPrimary,
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
            AsyncImage(
                model = homeTeamImage,
                contentDescription = homeTeamImage,
                modifier = Modifier.clickable { onHomeTeamClick() }
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TennisAppText(
                    text = date,
                    style = TennisTheme.typography.title1
                )

                TennisAppText(
                    text = "$homeTeamScore - $awayTeamScore",
                    style = TennisTheme.typography.title1
                )
                TennisAppText(
                    text = matchStatus,
                    style = TennisTheme.typography.title1
                )
            }
            AsyncImage(
                model = awayReamImage,
                contentDescription = awayReamImage,
                modifier = Modifier.clickable { onAwayTeamClick() }
            )
        }
    }
}

@Preview(
    name = "MatchDetailsHeader — Home Win (Light)",
    showBackground = true,
    widthDp = 360,
    heightDp = 120
)
@Composable
fun PreviewMatchDetailsHeader_HomeWin_Light() {
    TennisTheme {
        Surface {
            MatchDetailsHeader(
                tournamentName = "ATP Finals",
                homeTeamImage = "https://via.placeholder.com/64.png?text=HOME",
                awayReamImage = "https://via.placeholder.com/64.png?text=AWAY",
                homeTeamScore = 3,
                awayTeamScore = 1,
                date = "24.09.2025 20:00",
                matchStatus = "Finished",
                onHomeTeamClick = {},
                onAwayTeamClick = {},
                onTournamentClick = {},
                onBackClick = {}
            )
        }
    }
}
