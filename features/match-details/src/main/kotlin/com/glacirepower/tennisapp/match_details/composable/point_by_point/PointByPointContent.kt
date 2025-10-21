package com.glacirepower.tennisapp.match_details.composable.point_by_point

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacirepower.tennisapp.match_details.composable.SetButton
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme

@OptIn(InternalSerializationApi::class)
@Composable
fun PointByPointContent(
    state: MatchDetailsState,
    onSetClick: (Int) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = TennisTheme.dimensions.padding.l,
                    vertical = TennisTheme.dimensions.padding.s
                ),
            horizontalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.s)
        ) {
            state.sets.forEach { sets ->
                SetButton(
                    set = sets.set.toString(),
                    isSelected = state.set == sets.set
                ) { onSetClick(sets.set) }
            }
        }
        TennisAppDivider()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.serveDvo) { serveDvo ->
                GameItem(
                    serveDvo = serveDvo
                )
            }
        }
    }
}
