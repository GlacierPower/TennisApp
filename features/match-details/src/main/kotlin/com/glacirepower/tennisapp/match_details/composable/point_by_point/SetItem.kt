package com.glacirepower.tennisapp.match_details.composable.point_by_point

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.match_details.R
import theme.TennisTheme

@Composable
fun SetItem(
    isHomeServe: Boolean,
    isAwayServe: Boolean,
    homeScore: Int,
    awayScore: Int,
    isHomeLostServe: Boolean,
    isAwayLostServe: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = TennisTheme.dimensions.padding.l,
                vertical = TennisTheme.dimensions.padding.s
            ),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ScoreItem(
            isHomeServe = isHomeServe,
            isAwayServe = isAwayServe,
            isAwayLostServe = isAwayLostServe,
            isHomeLostServe = isHomeLostServe,
            homeScore = homeScore,
            awayScore = awayScore
        )
    }
}

@Composable
private fun ScoreItem(
    isHomeServe: Boolean,
    isAwayServe: Boolean,
    isAwayLostServe: Boolean,
    isHomeLostServe: Boolean,
    homeScore: Int,
    awayScore: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = TennisTheme.dimensions.padding.m),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isHomeServe) {
                LostServeItem(isHomeLostServe)
                TennisAppSpacer(size = TennisTheme.dimensions.space.s)
                Icon(
                    painter = painterResource(R.drawable.ic_tennis_ball),
                    contentDescription = null,
                    tint = TennisTheme.colors.iconPrimary
                )
            }
        }

        Box(
            modifier = Modifier.padding(horizontal = TennisTheme.dimensions.padding.s),
            contentAlignment = Alignment.Center
        ) {
            TennisAppText(
                text = "$homeScore - $awayScore",
                style = TennisTheme.typography.body2
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isAwayServe) {
                Icon(
                    painter = painterResource(R.drawable.ic_tennis_ball),
                    contentDescription = null,
                    tint = TennisTheme.colors.iconPrimary
                )
                TennisAppSpacer(size = TennisTheme.dimensions.space.s)
                LostServeItem(isAwayLostServe)
            }
        }
    }
}

@Composable
private fun LostServeItem(isLostServe: Boolean) {
    if (isLostServe) {
        Box(
            modifier = Modifier
                .background(
                    color = TennisTheme.colors.statusDanger,
                    shape = TennisTheme.shapes.xs
                )
                .padding(
                    horizontal = TennisTheme.dimensions.padding.xs,
                    vertical = TennisTheme.dimensions.padding.xxs
                )
        ) {
            TennisAppText(
                text = stringResource(R.string.match_details_lost_serve),
                color = TennisTheme.colors.textPrimary,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
