package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.player_profile.model.MatchStatus
import com.glacierpower.tennisapp.features.player_profile.R
import theme.TennisTheme

@Composable
fun PreviousMatchItem(
    date: String,
    homePlayerName: String,
    awayPlayerName: String,
    matchStatus: MatchStatus,
    isWin: Boolean,
    homeScore: String,
    awayScore: String,
    isHomeWin: Boolean,
    isAwayWin: Boolean
) {
    val homeWin = TennisTheme.colors.run { if (isHomeWin) textAccentSecondary else textPrimary }
    val awayWin = TennisTheme.colors.run { if (isAwayWin) textAccentSecondary else textPrimary }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = TennisTheme.dimensions.padding.s
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TennisAppText(
                text = date,
                style = TennisTheme.typography.body3
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.space10)
            Column(
                modifier = Modifier.weight(1f)
            ) {
                TennisAppText(
                    text = homePlayerName,
                    style = TennisTheme.typography.body3,
                    color = homeWin
                )
                TennisAppSpacer(size = TennisTheme.dimensions.space.extraSmall, isVertical = true)
                TennisAppText(
                    text = awayPlayerName,
                    style = TennisTheme.typography.body3,
                    color = awayWin
                )
            }
            when (matchStatus) {
                MatchStatus.ENDED -> {
                    Column {
                        TennisAppText(
                            text = homeScore,
                            style = TennisTheme.typography.body3
                        )
                        TennisAppSpacer(
                            size = TennisTheme.dimensions.space.extraSmall,
                            isVertical = true
                        )
                        TennisAppText(
                            text = awayScore,
                            style = TennisTheme.typography.body3
                        )
                    }
                }

                MatchStatus.WALKOVER -> {
                    TennisAppText(
                        text = stringResource(R.string.player_profile_walkover),
                        style = TennisTheme.typography.body3
                    )
                }

                MatchStatus.RETIRED -> {
                    TennisAppText(
                        text = stringResource(R.string.player_profile_retired),
                        style = TennisTheme.typography.body3
                    )
                }

                MatchStatus.NOT_STARTED -> {}
            }
            TennisAppSpacer(size = TennisTheme.dimensions.space.space10)
            StatusIcon(matchStatus, isWin)
        }
        TennisAppDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviousMatchPreview() {
    TennisTheme {
        PreviousMatchItem(
            date = "06.09.",
            homePlayerName = "Novak Djokovic",
            awayPlayerName = "Jannik Sinner",
            matchStatus = MatchStatus.WALKOVER,
            isWin = true,
            homeScore = "3",
            awayScore = "1",
            isHomeWin = true,
            isAwayWin = false
        )
    }
}
