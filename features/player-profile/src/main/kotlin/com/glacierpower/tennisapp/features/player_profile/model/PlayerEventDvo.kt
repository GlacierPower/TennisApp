package com.glacierpower.tennisapp.features.player_profile.model

import androidx.compose.runtime.Immutable
import models.player_details.events.MainStatModel

@Immutable
data class PlayerEventDvo(
    val date: String,
    val homeName: String,
    val awayName: String,
    val matchStatus: MatchStatus,
    val homeScore: String,
    val awayScore: String,
    val tournamentName: String,
    val groundType: String,
    val isWin: Boolean,
    val rankName: String,
    val isHomeWin: Boolean,
    val isAwayWin: Boolean,
    val eventId: String,
    val tournamentLogo: String,
    val mainStatModel: MainStatModel?
)
