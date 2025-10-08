package com.glacirepower.tennisapp.match_details.model

import androidx.compose.runtime.Immutable

@Immutable
data class MainStatsDvo(
    val aces: StatDvo?,
    val doubleFaults: StatDvo?,
    val firstServe: StatDvo?,
    val secondServe: StatDvo?
)

@Immutable
data class StatDvo(
    val home: Int,
    val away: Int
)
