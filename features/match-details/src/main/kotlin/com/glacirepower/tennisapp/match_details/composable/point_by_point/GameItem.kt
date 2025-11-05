package com.glacirepower.tennisapp.match_details.composable.point_by_point

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.common.TennisAppSpacer
import com.glacirepower.tennisapp.match_details.model.ServeDvo
import theme.TennisTheme

@Composable
fun GameItem(
    serveDvo: ServeDvo
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SetItem(
            isHomeServe = serveDvo.isHomeServe,
            isAwayServe = serveDvo.isAwayServe,
            homeScore = serveDvo.homeScore,
            awayScore = serveDvo.awayScore,
            isHomeLostServe = serveDvo.isHomeLostServe,
            isAwayLostServe = serveDvo.isAwayLostServe
        )

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = TennisTheme.dimensions.padding.m),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.s),
            maxItemsInEachRow = Int.MAX_VALUE
        ) {
            serveDvo.points.forEach { point ->
                PointItem(
                    homePoint = point.homePoint,
                    awayPoint = point.awayPoint
                )
                TennisAppSpacer(size = TennisTheme.dimensions.space.s)
            }
        }
    }
}
