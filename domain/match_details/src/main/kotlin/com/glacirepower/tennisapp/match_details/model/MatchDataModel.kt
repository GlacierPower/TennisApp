package com.glacirepower.tennisapp.match_details.model

data class MatchDataModel(
    val id: Long,
    val eventId: Long,
    val type: List<SetDataModel>
)
