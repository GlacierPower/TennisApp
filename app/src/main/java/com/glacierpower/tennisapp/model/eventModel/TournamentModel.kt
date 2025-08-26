package com.glacierpower.tennisapp.model.eventModel

data class TournamentModel(
    val category: CategoryModel?,
    val id:Int,
    val name:String,
    val priority:Int,
    val slug:String,
    val uniqueTournament: UniqueTournamentModel
)
