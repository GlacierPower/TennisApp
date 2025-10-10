package com.glacirepower.tennisapp.match_details.model

import androidx.compose.runtime.Immutable

@Immutable
data class StatisticDvo(
    val id: Int,
    val eventId: Int,
    val period: String,
    val group: String,
    val name: String,
    val homeValue: Int,
    val homeStat: String,
    val awayValue: Int,
    val awayStat: String,
    val compareCode: Int
)
