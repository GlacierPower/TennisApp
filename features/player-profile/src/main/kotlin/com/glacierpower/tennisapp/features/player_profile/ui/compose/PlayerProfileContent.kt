package com.glacierpower.tennisapp.features.player_profile.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glacierpower.tennisapp.features.player_profile.model.PlayerEventDvo
import theme.TennisTheme

@Composable
fun PlayerProfileContent(
    playerEvents: List<PlayerEventDvo>,
    country: String,
    name: String,
    age: String,
    rankName: String,
    imageUrl: String,
    flagUrl: String,
    modifier: Modifier = Modifier,
    onMatchClick: (String) -> Unit
) {
    val grouped = playerEvents.groupBy { it.eventId }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TennisTheme.colors.backgroundGlobe)
    ) {
        PlayerProfileHeader(
            country = country,
            name = name,
            age = age,
            rank = rankName,
            imageUrl = imageUrl,
            flagUrl = flagUrl
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            grouped.forEach { (_, matches) ->
                stickyHeader {
                    TournamentItem(
                        tournamentName = matches.first().tournamentName,
                        groundType = matches.first().groundType,
                        tournamentLogo = matches.first().tournamentLogo
                    )
                }

                items(matches) { event ->
                    PreviousMatchItem(
                        modifier = Modifier
                            .padding(horizontal = TennisTheme.dimensions.padding.l),
                        date = event.date,
                        homePlayerName = event.homeName,
                        awayPlayerName = event.awayName,
                        matchStatus = event.matchStatus,
                        isWin = event.isWin,
                        homeScore = event.homeScore,
                        awayScore = event.awayScore,
                        isHomeWin = event.isHomeWin,
                        isAwayWin = event.isAwayWin,
                        onMatchClick = { onMatchClick(event.eventId) },
                    )
                }
            }
        }
    }
}
