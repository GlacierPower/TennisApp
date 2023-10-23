package com.glacierpower.tennisapp.data.service.responce.live_event

data class Tournament(
    val category:Category?,
    val id:Int,
    val name:String,
    val priority:Int,
    val slug:String,
    val uniqueTournament:UniqueTournament
)
