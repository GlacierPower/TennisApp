package com.glacirepower.tennisapp.match_details.composable.point_by_point

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import theme.TennisTheme

@Composable
fun PointItem(
    homePoint: String,
    awayPoint: String
) {
    Box(
        modifier = Modifier
            .height(TennisTheme.dimensions.base.pointItemHeight)
            .border(
                width = TennisTheme.dimensions.base.borderSize,
                color = TennisTheme.colors.iconPrimary,
                shape = TennisTheme.shapes.xs
            )
            .padding(vertical = TennisTheme.dimensions.padding.xxs, horizontal = TennisTheme.dimensions.padding.s),
        contentAlignment = Alignment.Center
    ) {
        TennisAppText(
            text = "$homePoint:$awayPoint",
            style = TennisTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PointItemPreview() {
    TennisTheme {
        PointItem(
            homePoint = "0",
            awayPoint = "15")
    }
}
