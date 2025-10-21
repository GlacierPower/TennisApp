package com.glacierpower.tennisapp.core.design_system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun StatisticHorizontalBar(
    title: String,
    homeValue: Int,
    homeStat: String,
    awayValue: Int,
    awayStat: String,
    modifier: Modifier = Modifier
) {
    val total = (homeValue + awayValue).coerceAtLeast(1)
    val homeFraction = homeValue.toFloat() / total
    val awayFraction = awayValue.toFloat() / total

    val homeBarColor =
        if (homeValue > awayValue) TennisTheme.colors.statusDanger else TennisTheme.colors.textPrimary
    val awayBarColor =
        if (homeValue < awayValue) TennisTheme.colors.statusDanger else TennisTheme.colors.textPrimary

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TennisAppSpacer(size = TennisTheme.dimensions.space.s, isVertical = true)
        TennisAppText(
            text = title,
            style = TennisTheme.typography.body3
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = TennisTheme.dimensions.padding.l),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TennisAppText(
                text = homeStat,
                style = TennisTheme.typography.body3,
                maxLines = 1
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            TennisAppText(
                text = awayStat,
                style = TennisTheme.typography.body3,
                maxLines = 1
            )
        }
        TennisAppSpacer(size = TennisTheme.dimensions.space.s, isVertical = true)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = TennisTheme.dimensions.padding.l),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(TennisTheme.dimensions.space.s)
                        .clip(TennisTheme.shapes.xss)
                        .background(color = TennisTheme.colors.backgroundOnIsland)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(homeFraction)
                            .fillMaxHeight()
                            .align(Alignment.CenterEnd)
                            .clip(TennisTheme.shapes.xss)
                            .background(color = homeBarColor)
                    )
                }
            }
            TennisAppSpacer(size = TennisTheme.dimensions.space.xxs)
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(TennisTheme.dimensions.space.s)
                        .clip(TennisTheme.shapes.xss)
                        .background(color = TennisTheme.colors.backgroundOnIsland)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(awayFraction)
                            .fillMaxHeight()
                            .clip(TennisTheme.shapes.xss)
                            .background(color = awayBarColor)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StatisticHorizontalBarPreview() {
    TennisTheme {
        StatisticHorizontalBar(
            title = "",
            homeValue = 10,
            awayValue = 16,
            homeStat = "1",
            awayStat = "2",
        )
    }
}
