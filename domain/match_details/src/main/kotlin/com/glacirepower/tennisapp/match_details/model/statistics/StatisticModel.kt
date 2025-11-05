package com.glacirepower.tennisapp.match_details.model.statistics

data class StatisticModel(
    val id: Int,
    val eventId: Int,
    val period: String,
    val group: String,
    val name: String,
    val home: String,
    val away: String,
    val compareCode: Int
)
