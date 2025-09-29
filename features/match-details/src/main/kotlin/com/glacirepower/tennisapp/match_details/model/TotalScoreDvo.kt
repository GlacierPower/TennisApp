package com.glacirepower.tennisapp.match_details.model

import androidx.compose.runtime.Immutable

@Immutable
data class TotalScoreDvo(
    val homeTeamName: String,
    val awayTeamName: String,
    val setHome: String?,
    val setAway: String?,
    val firstSetHome: String,
    val secondSetHome: String,
    val thirdSetHome: String?,
    val fourthSetHome: String?,
    val fifthSetHome: String?,
    val firstSetAway: String,
    val secondSetAway: String,
    val thirdSetAway: String?,
    val fourthSetAway: String?,
    val fifthSetAway: String?,
    val matchTime: String?,
    val firstSetTime: String,
    val secondSetTime: String,
    val thirdSetTime: String,
    val fourthSetTime: String,
    val fifthSetTime: String,
    val firstSetTieHomeBreak: String?,
    val firstSetTieAwayBreak: String?,
    val secondSetTieHomeBreak: String?,
    val secondSetTieAwayBreak: String?,
    val thirdSetTieHomeBreak: String?,
    val thirdSetTieAwayBreak: String?,
    val fourthSetTieHomeBreak: String?,
    val fourthSetTieAwayBreak: String?,
    val fifthSetTieHomeBreak: String?,
    val fifthSetTieAwayBreak: String?
)
