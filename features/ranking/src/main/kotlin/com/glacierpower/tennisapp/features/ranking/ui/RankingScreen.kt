package com.glacierpower.tennisapp.features.ranking.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.glacierpower.tennisapp.features.ranking.ui.compose.RankingItem
import theme.TennisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankingScreen(
    onPlayerClick: (String, String) -> Unit,
    viewModel: RankingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        containerColor = TennisTheme.colors.backgroundGlobe,
        modifier = Modifier
            .systemBarsPadding(),
        topBar = {
            TopAppBar(
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
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = TennisTheme.colors.iconPrimary
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .background(color = TennisTheme.colors.backgroundGlobe)
                    .padding(paddingValues)
            ) {
                item {
                    TennisAppText(
                        modifier = Modifier.padding(
                            horizontal = TennisTheme.dimensions.padding.l,
                            vertical = TennisTheme.dimensions.padding.xs
                        ),
                        text = "${state.ranking.first().type}: ${state.ranking.first().officialUpdatedAt}",
                        style = TennisTheme.typography.title3
                    )
                    TennisAppDivider()
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = TennisTheme.colors.backgroundIsland)
                            .padding(
                                vertical = TennisTheme.dimensions.padding.xs,
                                horizontal = TennisTheme.dimensions.padding.l
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
                }
                items(
                    items = state.ranking,
                    key = { player -> player.id }
                ) { player ->
                    RankingItem(
                        rank = player.ranking.toString(),
                        name = player.team.name,
                        points = player.points.toString(),
                        onPlayerClick = {
                            onPlayerClick(
                                player.id.toString(),
                                player.ranking.toString()
                            )
                        },
                        flagUri = player.team.logo
                    )
                }
            }
        }
    }
}
