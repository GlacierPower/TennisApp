package com.glacierpower.tennisapp.features.ranking.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RankingItem(
    modifier: Modifier = Modifier,
    rank: String,
    name: String,
    points: String,
    onPlayerClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onPlayerClick() }
                .padding(horizontal = 24.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = "${rank}.",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = name,
                    fontSize = 14.sp
                )
            }
            Text(
                text = points,
                fontSize = 14.sp,
            )
        }
        HorizontalDivider(thickness = 1.dp)
    }
}
