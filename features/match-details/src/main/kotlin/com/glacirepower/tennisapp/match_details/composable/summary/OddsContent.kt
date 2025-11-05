package com.glacirepower.tennisapp.match_details.composable.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.match_details.R
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme
import com.glacierpower.tennisapp.core.design_system.R as DsR

@OptIn(InternalSerializationApi::class)
@Composable
fun OddsContent(
    homeOdds: Double,
    awayOdds: Double,
    isHomeWin: Boolean,
    isAwayWin: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(TennisTheme.colors.backgroundIsland),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TennisTheme.colors.backgroundGlobe)
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.xs
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TennisAppText(
                text = stringResource(DsR.string.odds),
                style = TennisTheme.typography.body2
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(end = TennisTheme.dimensions.padding.xl)
                .weight(1f),
                horizontalArrangement = Arrangement.End) {
                TennisAppText(
                    text = stringResource(R.string.home_team_odds),
                    style = TennisTheme.typography.body2
                )
                TennisAppSpacer(size = TennisTheme.dimensions.space.xxxl)
                TennisAppText(
                    text = stringResource(R.string.away_team_odds),
                    style = TennisTheme.typography.body2
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = TennisTheme.dimensions.padding.m,
                    horizontal = TennisTheme.dimensions.padding.l
                ),
            horizontalArrangement = Arrangement.End
        ) {
            OddsItem(
                odds = homeOdds.toString(),
                isWin = isHomeWin
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.l)
            OddsItem(
                odds = awayOdds.toString(),
                isWin = isAwayWin
            )
        }
    }
}

@Composable
private fun OddsItem(
    odds: String,
    isWin: Boolean
) {
    val boxModifier =
        if (isWin) Modifier.background(
            color = TennisTheme.colors.statusWarning,
            shape = TennisTheme.shapes.s
        ) else Modifier.border(
            width = 1.dp,
            color = TennisTheme.colors.iconPrimary,
            shape = TennisTheme.shapes.s
        )

    Box(
        modifier = boxModifier
            .padding(
                start = TennisTheme.dimensions.padding.xl,
                end = TennisTheme.dimensions.padding.s
            )
            .padding(vertical = TennisTheme.dimensions.padding.xs),
        contentAlignment = Alignment.CenterEnd
    ) {
        TennisAppText(
            text = odds,
            style = TennisTheme.typography.body2
        )
    }
}
