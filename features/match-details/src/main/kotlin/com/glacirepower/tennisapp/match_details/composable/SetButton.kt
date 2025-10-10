package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun SetButton(
    set: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor =
        if (isSelected) TennisTheme.colors.statusDanger else TennisTheme.colors.backgroundIsland
    Box(
        modifier = Modifier
            .background(color = backgroundColor, shape = TennisTheme.shapes.xs)
            .clickable { onClick() }
            .padding(TennisTheme.dimensions.padding.s),
        contentAlignment = Alignment.Center
    ) {
        TennisAppText(
            text = "Set $set",
            style = TennisTheme.typography.body3
        )
    }
}
