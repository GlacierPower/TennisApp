package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glacierpower.tennisapp.core.design_system.text.TennisAppText
import kotlinx.coroutines.launch
import theme.TennisTheme

@Composable
fun EventDetailsPager(
    modifier: Modifier = Modifier,
    initialPage: Int = 0,
    summaryContent:
    @Composable()
    (modifier: Modifier) -> Unit = {},
    statContent: @Composable (modifier: Modifier) -> Unit = { },
    oddsContent: @Composable (modifier: Modifier) -> Unit = { }
) {
    val pages: List<String> = listOf("Summary", "Stats", "Odds")
    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = TennisTheme.colors.backgroundGlobe,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = TennisTheme.colors.backgroundGlobe),
            indicator = { tabPositions ->
                EventDetailsIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .padding(horizontal = 24.dp),
                )
            }
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                    text = {
                        TennisAppText(
                            text = title,
                            style = TennisTheme.typography.body2
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> Column {
                    summaryContent(
                        Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                    )
                }

                1 -> statContent(
                    Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )

                2 -> oddsContent(
                    Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }
        }
    }
}

@Composable
private fun EventDetailsIndicator(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = TennisTheme.shapes.pagerIndicator
    ) {
        Box(
            modifier = Modifier
                .height(TennisTheme.dimensions.base.pagerIndicatorHeight)
                .background(color = TennisTheme.colors.statusDanger)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun EventDetailsPagerPreview() {
    TennisTheme {
        EventDetailsPager()
    }
}
