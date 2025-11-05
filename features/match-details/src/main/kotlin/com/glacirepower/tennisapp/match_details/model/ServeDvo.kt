package com.glacirepower.tennisapp.match_details.model

import androidx.compose.runtime.Immutable

@Immutable
data class ServeDvo(
    val isHomeLostServe: Boolean,
    val isAwayLostServe: Boolean,
    val isHomeServe: Boolean,
    val isAwayServe: Boolean,
    val homeScore: Int,
    val awayScore: Int,
    val points: List<PointDataModel>,
    val set: Int
)
