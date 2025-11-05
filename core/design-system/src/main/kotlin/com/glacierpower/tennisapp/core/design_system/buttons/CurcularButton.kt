package com.glacierpower.tennisapp.core.design_system.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import com.glacierpower.tennisapp.core.design_system.params_checker.TennisAppDesignSystemComponentId
import theme.TennisTheme

@Composable
fun TennisAppCircularButton(
    onClick: () -> Unit,
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier,
    colors: Color = TennisTheme.colors.backgroundGlobe,
    enabled: Boolean = true,
) {
    Box(
        modifier = modifier
            .layoutId(TennisCircularButton)
            .size(size = TennisTheme.dimensions.button.circularButtonSize)
            .clip(shape = TennisTheme.shapes.circularButton)
            .background(color = colors)
            .clickable(
                enabled = enabled,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "$iconId",
            modifier = modifier,
            tint = TennisTheme.colors.iconSecondary,
        )
    }
}

internal object TennisCircularButton : TennisAppDesignSystemComponentId
