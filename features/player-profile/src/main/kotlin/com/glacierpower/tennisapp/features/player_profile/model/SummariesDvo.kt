package com.glacierpower.tennisapp.features.player_profile.model

import androidx.compose.runtime.Immutable
import model.player_summaries.CompetitorsTotalModel

@Immutable
data class SummariesDvo(
    val date: String,
    val homeName: String,
    val awayName: String,
    val matchStatus: MatchStatus,
    val homeScore: Int,
    val awayScore: Int,
    val tournamentName: String,
    val tournamentCountry: String,
    val isWin: Boolean,
    val rankName: String,
    val isHomeWin: Boolean,
    val isAwayWin: Boolean,
    val eventId: String,
    val stat: List<CompetitorsTotalModel>
)
