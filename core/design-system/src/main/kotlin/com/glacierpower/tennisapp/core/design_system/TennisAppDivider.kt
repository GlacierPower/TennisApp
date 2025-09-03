package com.glacierpower.tennisapp.core.design_system

import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import theme.TennisTheme

@Composable
fun TennisAppDivider(
    modifier: Modifier = Modifier,
    isVertical: Boolean = false,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = TennisTheme.colors.dividerLight
) {
    if (isVertical) {
        VerticalDivider(
            modifier = modifier,
            thickness = thickness,
            color = color
        )
    } else {
        HorizontalDivider(
            modifier = modifier,
            thickness = thickness,
            color = color
        )
    }
}
