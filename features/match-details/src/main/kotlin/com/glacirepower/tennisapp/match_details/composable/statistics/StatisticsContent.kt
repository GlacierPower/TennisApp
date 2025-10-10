package com.glacirepower.tennisapp.match_details.composable.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.StatisticHorizontalBar
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacirepower.tennisapp.match_details.composable.SetButton
import com.glacirepower.tennisapp.match_details.model.StatisticDvo
import theme.TennisTheme

@Composable
fun StatisticsContent(
    statistics: List<StatisticDvo>,
    setStatistic: List<String>
) {
    val groped = statistics.groupBy { it.group }
    Column {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.s
                ),
            horizontalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.s)
        ) {
            setStatistic.forEach { set ->
                SetButton(
                    set = set,
                    isSelected = true,
                    onClick = {}
                )
            }
        }
        TennisAppDivider()
        LazyColumn {
            groped.forEach { (group, items) ->
                item {
                    StatisticsHeader(title = group)
                }
                items(items) { statistic ->
                    StatisticHorizontalBar(
                        title = statistic.name,
                        homeValue = statistic.homeValue,
                        awayValue = statistic.awayValue,
                        homeStat = statistic.homeStat,
                        awayStat = statistic.awayStat
                    )
                }
            }
        }
    }
}
