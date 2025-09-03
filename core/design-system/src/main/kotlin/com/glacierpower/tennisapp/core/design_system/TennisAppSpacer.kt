package com.glacierpower.tennisapp.core.design_system

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun TennisAppSpacer(
    modifier: Modifier = Modifier,
    size: Dp,
    isVertical: Boolean = false
) {
    val spaserModifier = if (isVertical) modifier.height(size) else modifier.width(size)
    Spacer(modifier = spaserModifier)
}
