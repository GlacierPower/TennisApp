package com.glacirepower.tennisapp.match_details.composable.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.glacierpower.tennisapp.core.design_system.StatisticHorizontalBar
import kotlinx.serialization.InternalSerializationApi
import com.glacierpower.tennisapp.core.design_system.R as DsR
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme
import utils.orZero
import com.glacierpower.tennisapp.features.match_details.R
import com.glacirepower.tennisapp.match_details.model.MainStatsDvo

@OptIn(InternalSerializationApi::class)
@Composable
fun MainStatsContent(
    mainStat: MainStatsDvo,
    onShowMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(TennisTheme.colors.backgroundIsland),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(TennisTheme.colors.backgroundGlobe)
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.xs
                )
        ) {
            TennisAppText(
                text = stringResource(DsR.string.stats),
                style = TennisTheme.typography.body2
            )
        }
        StatisticHorizontalBar(
            titleId = DsR.string.aces,
            homeValue = mainStat.aces?.home.orZero(),
            awayValue = mainStat.aces?.away.orZero()
        )
        StatisticHorizontalBar(
            titleId = DsR.string.doubleFaults,
            homeValue = mainStat.doubleFaults?.home.orZero(),
            awayValue = mainStat.doubleFaults?.away.orZero()
        )
        StatisticHorizontalBar(
            titleId = DsR.string.firstServe,
            homeValue = mainStat.firstServe?.home.orZero(),
            awayValue = mainStat.firstServe?.away.orZero()
        )
        StatisticHorizontalBar(
            titleId = DsR.string.secondServe,
            homeValue = mainStat.secondServe?.home.orZero(),
            awayValue = mainStat.secondServe?.away.orZero()
        )
        TennisAppText(
            text = stringResource(R.string.show_more),
            style = TennisTheme.typography.labelSmall,
            modifier = Modifier
                .padding(vertical = TennisTheme.dimensions.padding.xs)
                .clickable { onShowMoreClick() }

        )
    }
}
