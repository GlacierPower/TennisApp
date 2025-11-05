package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacirepower.tennisapp.match_details.MatchDetailsIntent
import com.glacirepower.tennisapp.match_details.composable.pager.EventDetailsPager
import com.glacirepower.tennisapp.match_details.composable.point_by_point.PointByPointContent
import com.glacirepower.tennisapp.match_details.composable.statistics.StatisticsContent
import com.glacirepower.tennisapp.match_details.composable.summary.MainStatsContent
import com.glacirepower.tennisapp.match_details.composable.summary.OddsContent
import com.glacirepower.tennisapp.match_details.composable.summary.TotalScoreContent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme
import utils.orFalse
import utils.orZero

@Composable
@InternalSerializationApi
fun MatchDetailsScreenContent(
    state: MatchDetailsState,
    matchDetailsIntent: MatchDetailsIntent
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TennisTheme.colors.backgroundGlobe)
    ) {
        state.eventDvo?.let { event ->
            MatchDetailsHeader(
                tournamentName = event.leagueName,
                homeTeamImage = event.homeTeamImage,
                awayTeamImage = event.awayTeamImage,
                homeTeamScore = event.homeTeamScore,
                awayTeamScore = event.awayTeamScore,
                date = event.date,
                matchStatus = event.matchStatus,
                onHomeTeamClick = { matchDetailsIntent.onHomeTeamClick(event.homeTeamId) },
                onAwayTeamClick = { matchDetailsIntent.onAwayTeamClick(event.awayTeamId) },
                onTournamentClick = { matchDetailsIntent.onTournamentClick(event.leagueId) },
                onBackClick = matchDetailsIntent::onNavigateBack,
                homeTeamName = event.homeTeamName,
                awayTeamName = event.awayTeamName,
                homeTeamCountry = event.homeTeamCountry,
                awayTeamCountry = event.awayTeamCountry,
                isWinner = event.isWinner
            )
        }
        EventDetailsPager(
            summaryContent = {
                state.scoreDvo?.let {
                    TotalScoreContent(scoreDvo = state.scoreDvo)
                }
                state.eventDvo?.mainStatsDvo?.let { mainStat ->
                    MainStatsContent(mainStat = mainStat, onShowMoreClick = {})
                }
                OddsContent(
                    isHomeWin = state.eventDvo?.isHomeWin.orFalse(),
                    isAwayWin = state.eventDvo?.isAwayWin.orFalse(),
                    homeOdds = state.eventDvo?.homeOdds.orZero(),
                    awayOdds = state.eventDvo?.awayOdds.orZero(),
                )
            },
            pointByPointContent = {
                PointByPointContent(
                    state,
                    onSetClick = matchDetailsIntent::onSetClick
                )
            },
            statContent = {
                StatisticsContent(
                    statistics = state.statistics,
                    setStatistic = state.setStatistic,
                )
            }
        )
    }
}
