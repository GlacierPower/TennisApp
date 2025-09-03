package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun PlayerProfileContent(
    country: String,
    name: String,
    age: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundOnIslandHover)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = TennisTheme.dimensions.padding.paddingL,
                    vertical = TennisTheme.dimensions.padding.paddingS
                )
        ) {
            TennisAppText(
                text = country,
                style = TennisTheme.typography.body3
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.space10, isVertical = true)
            TennisAppText(
                text = name,
                style = TennisTheme.typography.title3
            )
            TennisAppSpacer(size = TennisTheme.dimensions.space.space10, isVertical = true)
            TennisAppText(
                text = age,
                style = TennisTheme.typography.body3
            )
        }
    }
}
