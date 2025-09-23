package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme
import com.glacierpower.tennisapp.core.design_system.R as DsR

@Composable
fun PlayerProfileHeader(
    country: String,
    name: String,
    age: String,
    rank: String,
    imageUrl: String,
    flagUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundOnIslandHover)
            .padding(horizontal = TennisTheme.dimensions.padding.l, vertical = TennisTheme.dimensions.padding.m)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = flagUrl,
                contentDescription = null,
                modifier = Modifier.size(
                    height = TennisTheme.dimensions.icon.s,
                    width = TennisTheme.dimensions.icon.l
                )
            )
            TennisAppText(
                modifier = Modifier.padding(horizontal = TennisTheme.dimensions.padding.l),
                text = country,
                style = TennisTheme.typography.body3
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = TennisTheme.dimensions.padding.s),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null
            )
            Column {
                TennisAppSpacer(size = TennisTheme.dimensions.space.space10, isVertical = true)
                TennisAppText(
                    modifier = Modifier.padding(horizontal = TennisTheme.dimensions.padding.l),
                    text = name,
                    style = TennisTheme.typography.title3
                )
                TennisAppSpacer(size = TennisTheme.dimensions.space.space10, isVertical = true)
                TennisAppText(
                    modifier = Modifier.padding(horizontal = TennisTheme.dimensions.padding.l),
                    text = age,
                    style = TennisTheme.typography.body3
                )
            }
        }

        TennisAppDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = TennisTheme.dimensions.padding.s)
                    .background(
                        color = TennisTheme.colors.iconSecondary,
                        shape = TennisTheme.shapes.small
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .padding(TennisTheme.dimensions.padding.xs)
                        .size(TennisTheme.dimensions.icon.s),
                    painter = painterResource(DsR.drawable.ic_reating),
                    contentDescription = null,
                )
            }
            TennisAppSpacer(size = TennisTheme.dimensions.space.space10)
            TennisAppText(
                text = rank,
                style = TennisTheme.typography.body3
            )
        }
    }
}
