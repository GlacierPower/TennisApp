package com.glacierpower.tennisapp.features.player_profile.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.InternalSerializationApi
import model.events.MainStatModel

@InternalSerializationApi
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
    val leagueId: String,
    val tournamentLogo: String,
    val mainStatModel: MainStatModel?,
    val eventId: String
)
