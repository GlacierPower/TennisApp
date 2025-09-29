package com.glacirepower.tennisapp.match_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacirepower.tennisapp.match_details.MatchDetailsIntent
import com.glacirepower.tennisapp.match_details.mvi.MatchDetailsState
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme
import utils.orEmptyString

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
        state.event?.let { event ->
            MatchDetailsHeader(
                tournamentName = event.league.name,
                homeTeamImage = event.homeTeam.logo,
                awayTeamImage = event.awayTeam.logo,
                homeTeamScore = event.homeScore?.display.orEmptyString(),
                awayTeamScore = event.awayScore?.display.orEmptyString(),
                date = event.startAt,
                matchStatus = event.status,
                onHomeTeamClick = { matchDetailsIntent.onHomeTeamClick(event.homeTeamId.toString()) },
                onAwayTeamClick = { matchDetailsIntent.onAwayTeamClick(event.awayTeamId.toString()) },
                onTournamentClick = { matchDetailsIntent.onTournamentClick(event.leagueId.toString()) },
                onBackClick = matchDetailsIntent::onNavigateBack,
                homeTeamName = event.homeTeam.nameShort,
                awayTeamName = event.awayTeam.nameShort,
                homeTeamRank = event.homeTeam.countryCode,
                awayTeamRank = event.awayTeam.countryCode
            )
        }
        EventDetailsPager(
            summaryContent = {
                state.scoreDvo?.let {
                    TotalScoreContent(scoreDvo = state.scoreDvo)
                }
                state.event?.mainStat?.let { mainStat ->
                    MainStatsContent(mainStat = mainStat, onShowMoreClick = {})
                }
                OddsContent(
                    state.event?.mainOdds,
                    isHomeWin = state.event?.winnerCode == 1,
                    isAwayWin = state.event?.winnerCode == 2
                )
            }
        )
    }
}
