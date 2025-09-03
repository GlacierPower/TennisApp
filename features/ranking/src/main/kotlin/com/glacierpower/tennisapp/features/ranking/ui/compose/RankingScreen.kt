package com.glacierpower.tennisapp.features.ranking.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.glacierpower.tennisapp.core.design_system.common.TennisAppDivider
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import com.glacierpower.tennisapp.features.ranking.R
import com.glacierpower.tennisapp.features.ranking.ui.RankingViewModel
import theme.TennisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreen(
    onPlayerClick: (String) -> Unit
) {
    val viewModel: RankingViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        containerColor = TennisTheme.colors.backgroundGlobe,
        modifier = Modifier
            .systemBarsPadding(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = TennisTheme.dimensions.padding.paddingXl),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TennisTheme.colors.backgroundGlobe
                ),
                title = {
                    TennisAppText(
                        text = stringResource(R.string.ranking_screen_title),
                        style = TennisTheme.typography.title1
                    )
                })
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(color = TennisTheme.colors.backgroundGlobe)
                .padding(paddingValues)
        ) {
            if (state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = TennisTheme.colors.backgroundGlobe
                    )
                }
            } else {
                state.ranking.forEach { rankingModel ->
                    TennisAppText(
                        modifier = Modifier.padding(
                            horizontal = TennisTheme.dimensions.padding.paddingL,
                            vertical = TennisTheme.dimensions.padding.paddingXs
                        ),
                        text = "${rankingModel.name} ${
                            stringResource(
                                R.string.rankings_week,
                                rankingModel.week
                            )
                        }",
                        style = TennisTheme.typography.title3
                    )

                    TennisAppDivider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = TennisTheme.colors.backgroundIsland)
                            .padding(
                                vertical = TennisTheme.dimensions.padding.paddingXs,
                                horizontal = TennisTheme.dimensions.padding.paddingL
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TennisAppText(
                            text = stringResource(R.string.ranking_rank),
                            style = TennisTheme.typography.body3
                        )
                        TennisAppText(
                            text = stringResource(R.string.ranking_points),
                            style = TennisTheme.typography.body3
                        )
                    }
                    TennisAppDivider()
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
}
