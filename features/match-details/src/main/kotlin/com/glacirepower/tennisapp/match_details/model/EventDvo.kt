package com.glacirepower.tennisapp.match_details.model

import androidx.compose.runtime.Immutable

@Immutable
data class EventDvo(
    val leagueName: String,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamScore: String,
    val awayTeamScore: String,
    val date: String,
    val matchStatus: String,
    val isWinner: Boolean,
    val homeTeamImage: String,
    val awayTeamImage: String,
    val homeTeamCountry: String,
    val awayTeamCountry: String,
    val isHomeWin: Boolean,
    val isAwayWin: Boolean,
    val homeOdds: Double,
    val awayOdds: Double,
    val mainStatsDvo: MainStatsDvo?,
    val homeTeamId: String,
    val awayTeamId: String,
    val leagueId: String
)
