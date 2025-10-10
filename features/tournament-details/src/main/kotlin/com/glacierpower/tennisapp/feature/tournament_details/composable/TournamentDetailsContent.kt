package com.glacierpower.tennisapp.feature.tournament_details.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.feature.tournament_details.TournamentDetailsIntent
import com.glacierpower.tennisapp.feature.tournament_details.mvi.TournamentDetailsState
import kotlinx.serialization.InternalSerializationApi
import theme.TennisTheme
import utils.orZero

@OptIn(InternalSerializationApi::class)
@Composable
fun TournamentDetailsContent(
    state: TournamentDetailsState,
    intentListener: TournamentDetailsIntent
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = TennisTheme.dimensions.padding.l),
        verticalArrangement = Arrangement.spacedBy(TennisTheme.dimensions.space.xxs)
    ) {
        items(state.tournament.reversed()) { tournament ->
            EventItem(
                homeName = tournament.homeTeam.nameShort,
                awayName = tournament.awayTeam.nameShort,
                homeScore = tournament.awayScore?.display.orZero(),
                awayScore = tournament.awayScore?.display.orZero(),
                onEventClick = {}
            )
        }
    }
}
