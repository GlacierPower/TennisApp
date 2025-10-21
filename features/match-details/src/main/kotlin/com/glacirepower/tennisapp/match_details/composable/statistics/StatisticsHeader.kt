package com.glacirepower.tennisapp.match_details.composable.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun StatisticsHeader(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = TennisTheme.dimensions.padding.l)
    ) {
        TennisAppSpacer(size = TennisTheme.dimensions.space.s, isVertical = true)
        TennisAppText(
            text = title,
            style = TennisTheme.typography.body2
        )
        TennisAppSpacer(size = TennisTheme.dimensions.space.m, isVertical = true)
        TennisAppDivider()
    }
}
