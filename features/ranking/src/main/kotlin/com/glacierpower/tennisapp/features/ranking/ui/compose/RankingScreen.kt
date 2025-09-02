package com.glacierpower.tennisapp.features.ranking.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacierpower.tennisapp.features.ranking.R
import com.glacierpower.tennisapp.features.ranking.ui.RankingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreen(
    onPlayerClick: (String) -> Unit
) {
    val viewModel: RankingViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer),
                title = {
                    Text(
                        text = stringResource(R.string.ranking_screen_title)
                    )
                })
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            state.ranking.forEach { rankingModel ->
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp),
                    text = rankingModel.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = stringResource(R.string.rankings_week, rankingModel.week),
                        fontSize = 16.sp
                    )
                    HorizontalDivider(
                        thickness = 1.dp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = stringResource(R.string.ranking_rank), fontSize = 12.sp)
                        Text(text = stringResource(R.string.ranking_points), fontSize = 12.sp)
                    }
                    HorizontalDivider(
                        thickness = 1.dp
                    )
                }

                LazyColumn {
                    items(rankingModel.competitorRankings) { player ->
                        RankingItem(
                            rank = player.rank.toString(),
                            name = player.competitor.name,
                            points = player.points.toString(),
                            onPlayerClick = { onPlayerClick(player.competitor.id) }
                        )
                    }
                }
            }
        }
    }
}
